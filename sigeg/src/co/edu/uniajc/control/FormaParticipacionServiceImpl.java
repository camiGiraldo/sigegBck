package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.FormaParticipacion;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class FormaParticipacionServiceImpl implements FormaParticipacionService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getFormasParticipacion() {
		return businessDelegatorView.getAllEntities(FormaParticipacion.class);
	}

	@Override
	public Object getFormaParticipacionById(String idFormaParticipacion) {
		if (!idFormaParticipacion.isEmpty() && Utilities.isNumeric(idFormaParticipacion)) {
			return businessDelegatorView.getEntityById(FormaParticipacion.class, Long.parseLong(idFormaParticipacion));
		} else {
			throw new ZMessManager.InvalidEntityException("Id no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Object saveFormaParticipacion(Map<String, String> entity) {
		FormaParticipacion forma = new FormaParticipacion();
		if (entity.get(Utilities.IDFORMAPARTICIPACION).isEmpty()) {
			setCamposForma(forma, entity);
			businessDelegatorView.saveGeneric(forma);
		} else {
			forma = (FormaParticipacion) getFormaParticipacionById(entity.get(Utilities.IDFORMAPARTICIPACION));
			if (forma == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Forma Participacion con Id %s", entity.get(Utilities.IDFORMAPARTICIPACION)));
			}
			setCamposForma(forma, entity);
			businessDelegatorView.updateGeneric(forma);
		}
		return forma.getIdFormaParticipacion();
	}

	private void setCamposForma(FormaParticipacion forma, Map<String, String> entity) {
		forma.setNombre(entity.get("nombre"));
		if (Utilities.isNumeric(entity.get("activo"))) {
			forma.setActivo(Long.parseLong(entity.get("activo")));
		}
		Iterator<ConstraintViolation<FormaParticipacion>> violations = Utilities.getValidator().validate(forma).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
