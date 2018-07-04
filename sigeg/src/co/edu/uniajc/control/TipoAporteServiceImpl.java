package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.TipoAporte;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class TipoAporteServiceImpl implements TipoAporteService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getTiposAporte() {
		return businessDelegatorView.getAllEntities(TipoAporte.class);
	}

	@Override
	public Object getTipoAporteById(String idTipoAporte) {
		if (!idTipoAporte.isEmpty() && Utilities.isNumeric(idTipoAporte) && idTipoAporte.length() <= 10) {
			return businessDelegatorView.getEntityById(TipoAporte.class, Long.parseLong(idTipoAporte));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Tipo Aporte no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Long saveTipoAporte(Map<String, String> entity) {
		TipoAporte tipoAporte = new TipoAporte();
		if (entity.get(Utilities.IDTIPOAPORTE).isEmpty()) {
			setCamposTipoAporte(tipoAporte, entity);
			businessDelegatorView.saveGeneric(tipoAporte);
		} else {
			tipoAporte = (TipoAporte) getTipoAporteById(entity.get(Utilities.IDTIPOAPORTE));
			if (tipoAporte == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Tipo Aporte con Id %s", entity.get(Utilities.IDTIPOAPORTE)));
			}
			setCamposTipoAporte(tipoAporte, entity);
			businessDelegatorView.updateGeneric(tipoAporte);
		}
		return tipoAporte.getIdTipoAporte();
	}

	private void setCamposTipoAporte(TipoAporte tipoAporte, Map<String, String> entity) {
		tipoAporte.setNombre(entity.get("nombre"));
		if (Utilities.isNumeric(entity.get("activo"))) {
			tipoAporte.setActivo(Long.parseLong(entity.get("activo")));
		}
		Iterator<ConstraintViolation<TipoAporte>> violations = Utilities.getValidator().validate(tipoAporte).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
