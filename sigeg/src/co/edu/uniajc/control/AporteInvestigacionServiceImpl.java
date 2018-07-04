package co.edu.uniajc.control;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.AporteInvestigacion;
import co.edu.dataaccess.dao.EgresadoAporte;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class AporteInvestigacionServiceImpl implements AporteInvestigacionService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getAportes() {
		return businessDelegatorView.getAllEntities(AporteInvestigacion.class);
	}

	@Override
	public Object getAporteById(String idAporteInvestigacion) {
		if (!idAporteInvestigacion.isEmpty() && Utilities.isNumeric(idAporteInvestigacion)) {
			return businessDelegatorView.getEntityById(AporteInvestigacion.class, Long.parseLong(idAporteInvestigacion));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Aporte Investigacion no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Object saveAporteInvestigacion(Map<String, String> entity) {
		AporteInvestigacion aporte = new AporteInvestigacion();
		if (entity.get(Utilities.IDAPORTEINVESTIGACION).isEmpty()) {
			setCamposAporte(aporte, entity);
			businessDelegatorView.saveGeneric(aporte);
		} else {
			aporte = (AporteInvestigacion) getAporteById(entity.get(Utilities.IDAPORTEINVESTIGACION));
			if (aporte == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Aporte Investigacion con Id %s", entity.get(Utilities.IDAPORTEINVESTIGACION)));
			}
			setCamposAporte(aporte, entity);
			businessDelegatorView.updateGeneric(aporte);
		}
		return aporte.getIdAporteInvestigacion();
	}

	private void setCamposAporte(AporteInvestigacion aporte, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get("idTipoAporte"))) {
			aporte.setIdTipoAporte(Long.parseLong(entity.get("idTipoAporte")));
		}
		if (Utilities.isNumeric(entity.get("fechaRealizacion"))) {
			aporte.setFechaRealizacion(new Date(Long.parseLong(entity.get("fechaRealizacion"))));
		}
		if (Utilities.isNumeric(entity.get("fechaFinalizacion"))) {
			aporte.setFechaFinalizacion(new Date(Long.parseLong(entity.get("fechaFinalizacion"))));
		}
		aporte.setGrupoBeneficiario(entity.get("grupoBeneficiario"));
		aporte.setSubGrupoBeneficiario(entity.get("subGrupoBeneficiario"));
		aporte.setNombreProyecto(entity.get("nombreProyecto"));
		aporte.setDescripcionProyecto(entity.get("descripcionProyecto"));
		aporte.setPersonaACargo(entity.get("personaACargo"));
		aporte.setCorreoElectronico(entity.get("correoElectronico"));
		aporte.setTelefono(entity.get("telefono"));
		if (Utilities.isNumeric(entity.get("adjunto"))) {
			aporte.setAdjunto(Long.parseLong(entity.get("adjunto")));
		}
		if (aporte.getIdAporteInvestigacion() == null) {
			aporte.setFechaCreacion(new Date(System.currentTimeMillis()));
		}
		Iterator<ConstraintViolation<AporteInvestigacion>> violations = Utilities.getValidator().validate(aporte).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public List<Object> getEgresadoAporteByIdAporte(String idAporteInvestigacion) {
		if (!idAporteInvestigacion.isEmpty() && Utilities.isNumeric(idAporteInvestigacion)) {
			return businessDelegatorView.getFindCriteriaGeneric(EgresadoAporte.class, "idAporteInvestigacion=?1", new Object[] { Long.parseLong(idAporteInvestigacion) });
		} else {
			throw new ZMessManager.InvalidEntityException("Id Aporte Investigacion no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Object getEgresadoAporteById(String idEgresadoAporte) {
		if (!idEgresadoAporte.isEmpty() && Utilities.isNumeric(idEgresadoAporte)) {
			return businessDelegatorView.getEntityById(EgresadoAporte.class, Long.parseLong(idEgresadoAporte));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Egresado Aporte no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Object saveEgresadoAporte(Map<String, String> entity) {
		EgresadoAporte egresadoAporte = new EgresadoAporte();
		if (entity.get(Utilities.IDEGRESADOAPORTE).isEmpty()) {
			setCamposEgresadoAporte(egresadoAporte, entity);
			businessDelegatorView.saveGeneric(egresadoAporte);
		} else {
			egresadoAporte = (EgresadoAporte) getEgresadoAporteById(entity.get(Utilities.IDEGRESADOAPORTE));
			if (egresadoAporte == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Egresado Aporte con Id %s", entity.get(Utilities.IDEGRESADOAPORTE)));
			}
			setCamposEgresadoAporte(egresadoAporte, entity);
			businessDelegatorView.updateGeneric(egresadoAporte);
		}
		return egresadoAporte.getIdEgresadoAporte();
	}

	private void setCamposEgresadoAporte(EgresadoAporte egresadoAporte, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get(Utilities.IDAPORTEINVESTIGACION))) {
			egresadoAporte.setIdAporteInvestigacion(Long.parseLong(entity.get(Utilities.IDAPORTEINVESTIGACION)));
		}
		if (Utilities.isNumeric(entity.get("idEgresado"))) {
			egresadoAporte.setIdEgresado(Long.parseLong(entity.get("idEgresado")));
		}
		egresadoAporte.setParticipacion(entity.get("participacion"));
		egresadoAporte.setUrlExterna(entity.get("urlExterna"));
		if (Utilities.isNumeric(entity.get("soporte"))) {
			egresadoAporte.setSoporte(Long.parseLong(entity.get("soporte")));
		}
		Iterator<ConstraintViolation<EgresadoAporte>> violations = Utilities.getValidator().validate(egresadoAporte).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
