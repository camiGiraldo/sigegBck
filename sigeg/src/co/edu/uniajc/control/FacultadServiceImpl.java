package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.Facultad;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class FacultadServiceImpl implements FacultadService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getFacultades() {
		return businessDelegatorView.getAllEntities(Facultad.class);
	}

	@Override
	public Object getFacultadById(String idFacultad) {
		if (!idFacultad.isEmpty() && Utilities.isNumeric(idFacultad) && idFacultad.length() <= 10) {
			return businessDelegatorView.getEntityById(Facultad.class, Long.parseLong(idFacultad));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Facultad no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Object saveFacultad(Map<String, String> entity) {
		Facultad facultad = new Facultad();
		if (entity.get(Utilities.IDFACULTAD).isEmpty()) {
			setCamposFacultad(facultad, entity);
			businessDelegatorView.saveGeneric(facultad);
		} else {
			facultad = (Facultad) getFacultadById(entity.get(Utilities.IDFACULTAD));
			if (facultad == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Facultad con Id %s", entity.get(Utilities.IDFACULTAD)));
			}
			setCamposFacultad(facultad, entity);
			businessDelegatorView.updateGeneric(facultad);
		}
		return facultad.getIdFacultad();
	}

	private void setCamposFacultad(Facultad facultad, Map<String, String> entity) {
		facultad.setNombre(entity.get("nombre"));
		facultad.setAbreviatura(entity.get("abreviatura"));
		Iterator<ConstraintViolation<Facultad>> violations = Utilities.getValidator().validate(facultad).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
