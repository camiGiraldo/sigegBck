package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.Programa;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class ProgramaServiceImpl implements ProgramaService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getProgramas() {
		return businessDelegatorView.getAllEntities(Programa.class);
	}

	@Override
	public Object getProgramaById(String idPrograma) {
		if (!idPrograma.isEmpty() && Utilities.isNumeric(idPrograma) && idPrograma.length() < 10) {
			return businessDelegatorView.getEntityById(Programa.class, Long.parseLong(idPrograma));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Programa no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Long savePrograma(Map<String, String> entity) {
		Programa programa = new Programa();
		if (entity.get(Utilities.IDPROGRAMA).isEmpty()) {
			setCamposPrograma(programa, entity);
			businessDelegatorView.saveGeneric(programa);
		} else {
			programa = (Programa) getProgramaById(entity.get(Utilities.IDPROGRAMA));
			if (programa == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Programa con Id %s", entity.get(Utilities.IDPROGRAMA)));
			}
			setCamposPrograma(programa, entity);
			businessDelegatorView.updateGeneric(programa);
		}
		return programa.getIdPrograma();
	}

	private void setCamposPrograma(Programa programa, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get("idFacultad"))) {
			programa.setIdFacultad(Long.parseLong(entity.get("idFacultad")));
		}
		programa.setNombre(entity.get("nombre"));
		programa.setAbreviatura(entity.get("abreviatura"));
		Iterator<ConstraintViolation<Programa>> violations = Utilities.getValidator().validate(programa).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
