package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.TipoReconocimiento;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class TipoReconocimientoServiceImpl implements TipoReconocimientoService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getTiposReconocimiento() {
		return businessDelegatorView.getAllEntities(TipoReconocimiento.class);
	}

	@Override
	public Object getTipoReconocimientoById(String idTipoReconocimiento) {
		if (!idTipoReconocimiento.isEmpty() && Utilities.isNumeric(idTipoReconocimiento) && idTipoReconocimiento.length() <= 10) {
			return businessDelegatorView.getEntityById(TipoReconocimiento.class, Long.parseLong(idTipoReconocimiento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Facultad no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Long saveTipoReconocimiento(Map<String, String> entity) {
		TipoReconocimiento tipoReconocimiento = new TipoReconocimiento();
		if (entity.get(Utilities.IDTIPORECONOCIMIENTO).isEmpty()) {
			setCamposTipoReconocimiento(tipoReconocimiento, entity);
			businessDelegatorView.saveGeneric(tipoReconocimiento);
		} else {
			tipoReconocimiento = (TipoReconocimiento) getTipoReconocimientoById(entity.get(Utilities.IDTIPORECONOCIMIENTO));
			if (tipoReconocimiento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Tipo Reconocimiento con Id %s", entity.get(Utilities.IDTIPORECONOCIMIENTO)));
			}
			setCamposTipoReconocimiento(tipoReconocimiento, entity);
			businessDelegatorView.updateGeneric(tipoReconocimiento);
		}
		return tipoReconocimiento.getIdTipoReconocimiento();
	}

	private void setCamposTipoReconocimiento(TipoReconocimiento tipoReconocimiento, Map<String, String> entity) {
		tipoReconocimiento.setNombre(entity.get("nombre"));
		if (Utilities.isNumeric(entity.get("activo"))) {
			tipoReconocimiento.setActivo(Long.parseLong(entity.get("activo")));
		}
		Iterator<ConstraintViolation<TipoReconocimiento>> violations = Utilities.getValidator().validate(tipoReconocimiento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
