package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.TipoEvento;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class TipoEventoServiceImpl implements TipoEventoService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getTiposEvento() {
		return businessDelegatorView.getAllEntities(TipoEvento.class);
	}

	@Override
	public Object getTipoEventoById(String idTipoEvento) {
		if (!idTipoEvento.isEmpty() && Utilities.isNumeric(idTipoEvento) && idTipoEvento.length() <= 10) {
			return businessDelegatorView.getEntityById(TipoEvento.class, Long.parseLong(idTipoEvento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id TipoEvento no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Long saveTipoEvento(Map<String, String> entity) {
		TipoEvento tipoEvento = new TipoEvento();
		if (entity.get(Utilities.IDTIPOEVENTO).isEmpty()) {
			setCamposTipoEvento(tipoEvento, entity);
			businessDelegatorView.saveGeneric(tipoEvento);
		} else {
			tipoEvento = (TipoEvento) getTipoEventoById(entity.get(Utilities.IDTIPOEVENTO));
			if (tipoEvento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Tipo Evento con Id %s", entity.get(Utilities.IDTIPOEVENTO)));
			}
			setCamposTipoEvento(tipoEvento, entity);
			businessDelegatorView.updateGeneric(tipoEvento);
		}
		return tipoEvento.getIdTipoEvento();
	}

	private void setCamposTipoEvento(TipoEvento tipoEvento, Map<String, String> entity) {
		tipoEvento.setNombre(entity.get("nombre"));
		if (Utilities.isNumeric(entity.get("idCategoriaEvento"))) {
			tipoEvento.setIdCategoriaEvento(Long.parseLong(entity.get("idCategoriaEvento")));
		}
		if (Utilities.isNumeric(entity.get("activo"))) {
			tipoEvento.setActivo(Long.parseLong(entity.get("activo")));
		}
		Iterator<ConstraintViolation<TipoEvento>> violations = Utilities.getValidator().validate(tipoEvento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
