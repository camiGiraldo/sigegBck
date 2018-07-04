package co.edu.uniajc.control;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.EgresadoReconocimiento;
import co.edu.dataaccess.dao.Reconocimiento;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class ReconocimientoServiceImpl implements ReconocimientoService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getReconocimientos() {
		return businessDelegatorView.getAllEntities(Reconocimiento.class);
	}

	@Override
	public Object getReconocimientoById(String idReconocimiento) {
		if (!idReconocimiento.isEmpty() && Utilities.isNumeric(idReconocimiento) && idReconocimiento.length() <= 10) {
			return businessDelegatorView.getEntityById(Reconocimiento.class, Long.parseLong(idReconocimiento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Reconocimiento no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Object saveReconocimiento(Map<String, String> entity) {
		Reconocimiento reconocimiento = new Reconocimiento();
		if (entity.get(Utilities.IDRECONOCIMIENTO).isEmpty()) {
			setCamposReconocimiento(reconocimiento, entity);
			businessDelegatorView.saveGeneric(reconocimiento);
		} else {
			reconocimiento = (Reconocimiento) getReconocimientoById(entity.get(Utilities.IDRECONOCIMIENTO));
			if (reconocimiento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Reconocimiento con Id %s", entity.get(Utilities.IDRECONOCIMIENTO)));
			}
			setCamposReconocimiento(reconocimiento, entity);
			businessDelegatorView.updateGeneric(reconocimiento);
		}
		return reconocimiento.getIdReconocimiento();
	}

	private void setCamposReconocimiento(Reconocimiento reconocimiento, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get("idTipoReconocimiento"))) {
			reconocimiento.setIdTipoReconocimiento(Long.parseLong(entity.get("idTipoReconocimiento")));
		}
		if (Utilities.isNumeric(entity.get("adjunto"))) {
			reconocimiento.setAdjunto(Long.parseLong(entity.get("adjunto")));
		}
		if (Utilities.isNumeric(entity.get("fechaVinculacion"))) {
			reconocimiento.setFechaVinculacion(new Date(Long.parseLong(entity.get("fechaVinculacion"))));
		}
		reconocimiento.setLugarRealizacion(entity.get("lugarRealizacion"));
		reconocimiento.setBeneficiario(entity.get("beneficiario"));
		reconocimiento.setDescripcion(entity.get("descripcion"));
		if (Utilities.isNumeric(entity.get(Utilities.SOPORTE))) {
			reconocimiento.setSoporte(Long.parseLong(entity.get(Utilities.SOPORTE)));
		}
		if (reconocimiento.getIdReconocimiento() == null) {
			reconocimiento.setFechaCreacion(new Date(System.currentTimeMillis()));
		}
		Iterator<ConstraintViolation<Reconocimiento>> violations = Utilities.getValidator().validate(reconocimiento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public List<Object> getEgresadoReconocimientosByIdReconocimiento(String idReconocimiento) {
		if (!idReconocimiento.isEmpty() && Utilities.isNumeric(idReconocimiento) && idReconocimiento.length() <= 10) {
			return businessDelegatorView.getFindCriteriaGeneric(EgresadoReconocimiento.class, "idReconocimiento = ?1 ", new Object[] { Long.parseLong(idReconocimiento) });
		} else {
			throw new ZMessManager.InvalidEntityException("Id Reconocimiento no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Object getEgresadoReconocimientoById(String idEgresadoReconocimiento) {
		if (!idEgresadoReconocimiento.isEmpty() && Utilities.isNumeric(idEgresadoReconocimiento) && idEgresadoReconocimiento.length() <= 10) {
			return businessDelegatorView.getEntityById(EgresadoReconocimiento.class, Long.parseLong(idEgresadoReconocimiento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Egresado Reconocimiento no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Long saveEgresadoReconocimiento(Map<String, String> entity) {
		EgresadoReconocimiento egresadoReconocimiento = new EgresadoReconocimiento();
		if (entity.get(Utilities.IDEGRESADORECONICIMIENTO).isEmpty()) {
			setCamposEgresadoReconocimiento(egresadoReconocimiento, entity);
			businessDelegatorView.saveGeneric(egresadoReconocimiento);
		} else {
			egresadoReconocimiento = (EgresadoReconocimiento) getEgresadoReconocimientoById(entity.get(Utilities.IDEGRESADORECONICIMIENTO));
			if (egresadoReconocimiento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Egresado Reconocimiento con Id %s", entity.get(Utilities.IDEGRESADORECONICIMIENTO)));
			}
			setCamposEgresadoReconocimiento(egresadoReconocimiento, entity);
			businessDelegatorView.updateGeneric(egresadoReconocimiento);
		}
		return egresadoReconocimiento.getIdEgresadoReconocimiento();
	}

	private void setCamposEgresadoReconocimiento(EgresadoReconocimiento egresadoReconocimiento, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get(Utilities.IDRECONOCIMIENTO))) {
			egresadoReconocimiento.setIdReconocimiento(Long.parseLong(entity.get(Utilities.IDRECONOCIMIENTO)));
		}
		if (Utilities.isNumeric(entity.get("idEgresado"))) {
			egresadoReconocimiento.setIdEgresado(Long.parseLong(entity.get("idEgresado")));
		}
		if (Utilities.isNumeric(entity.get("distinguido"))) {
			egresadoReconocimiento.setDistinguido(Long.parseLong(entity.get("distinguido")));
		}
		if (Utilities.isNumeric(entity.get("vinculadoLaboralmente"))) {
			egresadoReconocimiento.setVinculadoLaboralmente(Long.parseLong(entity.get("vinculadoLaboralmente")));
		}
		if (Utilities.isNumeric(entity.get("logroPublicado"))) {
			egresadoReconocimiento.setLogroPublicado(Long.parseLong(entity.get("logroPublicado")));
		}
		egresadoReconocimiento.setUrlExterna(entity.get("urlExterna"));
		if (Utilities.isNumeric(entity.get(Utilities.SOPORTE))) {
			egresadoReconocimiento.setSoporte(Long.parseLong(entity.get(Utilities.SOPORTE)));
		}
		Iterator<ConstraintViolation<EgresadoReconocimiento>> violations = Utilities.getValidator().validate(egresadoReconocimiento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
