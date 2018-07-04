package co.edu.uniajc.control;

import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.Egresado;
import co.edu.dataaccess.dao.InformacionAcademica;
import co.edu.dataaccess.dao.InformacionControl;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class EgresadoServiceImpl implements EgresadoService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getEgresados() {
		return businessDelegatorView.getAllEntities(Egresado.class);
	}

	@Override
	public Object getEgresadoById(String idEgresado) {
		if (!idEgresado.isEmpty() && Utilities.isNumeric(idEgresado) && idEgresado.length() <= 10) {
			return businessDelegatorView.getEntityById(Egresado.class, Long.parseLong(idEgresado));
		} else {
			throw new ZMessManager.InvalidEntityException(Utilities.IDEGRESADONOTEMPTY);
		}
	}

	@Override
	public Long saveEgresado(Map<String, String> entity) {
		Egresado egresado = new Egresado();
		if (entity.get(Utilities.IDEGRESADO).isEmpty()) {
			setCamposEgresado(egresado, entity);
			businessDelegatorView.saveGeneric(egresado);
		} else {
			egresado = (Egresado) businessDelegatorView.getEntityById(Egresado.class, Long.parseLong(entity.get(Utilities.IDEGRESADO)));
			if (egresado == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Egresado con Id %s", entity.get(Utilities.IDEGRESADO)));
			}
			setCamposEgresado(egresado, entity);
			businessDelegatorView.updateGeneric(egresado);
		}
		return egresado.getIdEgresado();
	}

	private void setCamposEgresado(Egresado egresado, Map<String, String> entity) {
		egresado.setNombres(entity.get("nombres"));
		egresado.setApellidos(entity.get("apellidos"));
		egresado.setTipoIdentificacion(entity.get("tipoIdentificacion"));
		egresado.setIdentificacion(entity.get("identificacion"));
		egresado.setCiudadExpedicion(entity.get("ciudadExpedicion"));
		egresado.setPaisResidencia(entity.get("paisResidencia"));
		egresado.setCiudadResidencia(entity.get("ciudadResidencia"));
		egresado.setDireccionResidencia(entity.get("direccionResidencia"));
		if (Utilities.isNumeric(entity.get("telefonoFijo"))) {
			egresado.setTelefonoFijo(Long.parseLong(entity.get("telefonoFijo")));
		}
		if (Utilities.isNumeric(entity.get("telefonoMovil"))) {
			egresado.setTelefonoMovil(Long.parseLong(entity.get("telefonoMovil")));
		}
		if (Utilities.isNumeric(entity.get("telefonoMovilAlterno"))) {
			egresado.setTelefonoMovilAlterno(Long.parseLong(entity.get("telefonoMovilAlterno")));
		}
		egresado.setCorreoElectronico(entity.get("correoElectronico"));
		egresado.setCorreoElectronicoAlterno(entity.get("correoElectronicoAlterno"));
		if (egresado.getIdEgresado() == null) {
			egresado.setFechaCreacion(new Date(System.currentTimeMillis()));
		}
		Iterator<ConstraintViolation<Egresado>> violations = Utilities.getValidator().validate(egresado).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public Object getInfoAcademicaById(String idInformacionAcademica) {
		if (!idInformacionAcademica.isEmpty() && Utilities.isNumeric(idInformacionAcademica) && idInformacionAcademica.length() <= 10) {
			return businessDelegatorView.getEntityById(InformacionAcademica.class, Long.parseLong(idInformacionAcademica));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Informacion Academica no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public List<Object> getInfoAcademicaByIdEgresado(String idEgresado) {
		if (!idEgresado.isEmpty() && Utilities.isNumeric(idEgresado) && idEgresado.length() <= 10) {
			return businessDelegatorView.getFindCriteriaGeneric(InformacionAcademica.class, "IdEgresado = ?1", new Object[] { Long.parseLong(idEgresado) });
		} else {
			throw new ZMessManager.InvalidEntityException(Utilities.IDEGRESADONOTEMPTY);
		}
	}

	@Override
	public Long saveInfoAcademica(Map<String, String> entity) {
		InformacionAcademica informacionAcademica = new InformacionAcademica();
		if (entity.get(Utilities.IDINFORMACIONACADEMICA).isEmpty()) {
			setCamposInfoAcademica(informacionAcademica, entity);
			businessDelegatorView.saveGeneric(informacionAcademica);
		} else {
			informacionAcademica = (InformacionAcademica) getInfoAcademicaById(entity.get(Utilities.IDINFORMACIONACADEMICA));
			if (informacionAcademica == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Información Académica con Id %s", entity.get(Utilities.IDINFORMACIONACADEMICA)));
			}
			setCamposInfoAcademica(informacionAcademica, entity);
			businessDelegatorView.updateGeneric(informacionAcademica);
		}
		return informacionAcademica.getIdInformacionAcademica();
	}

	private void setCamposInfoAcademica(InformacionAcademica informacionAcademica, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get(Utilities.IDEGRESADO))) {
			informacionAcademica.setIdEgresado(Long.parseLong(entity.get(Utilities.IDEGRESADO)));
		}
		if (Utilities.isNumeric(entity.get("idPrograma"))) {
			informacionAcademica.setIdPrograma(Long.parseLong(entity.get("idPrograma")));
		}
		informacionAcademica.setLibro(entity.get("libro"));
		informacionAcademica.setFolio(entity.get("folio"));
		informacionAcademica.setActa(entity.get("acta"));
		informacionAcademica.setNumeroDiploma(entity.get("numeroDiploma"));
		informacionAcademica.setSemestreGrado(entity.get("semestreGrado"));
		informacionAcademica.setFormaGrado(entity.get("formaGrado"));
		informacionAcademica.setTipoOpcionGrado(entity.get("tipoOpcionGrado"));
		informacionAcademica.setNotaOpcionGrado(entity.get("notaOpcionGrado"));
		informacionAcademica.setSemestreFinalizoMaterias(entity.get("semestreFinalizoMaterias"));
		Iterator<ConstraintViolation<InformacionAcademica>> violations = Utilities.getValidator().validate(informacionAcademica).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public Object getInfoControlById(String idInformacionControl) {
		if (!idInformacionControl.isEmpty() && Utilities.isNumeric(idInformacionControl) && idInformacionControl.length() <= 10) {
			return businessDelegatorView.getEntityById(InformacionControl.class, Long.parseLong(idInformacionControl));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Informacion Control no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public List<Object> getInfoControlByIdEgresado(String idEgresado) {
		if (!idEgresado.isEmpty() && Utilities.isNumeric(idEgresado) && idEgresado.length() <= 10) {
			return businessDelegatorView.getFindCriteriaGeneric(InformacionControl.class, "IdEgresado = ?1", new Object[] { Long.parseLong(idEgresado) });
		} else {
			throw new ZMessManager.InvalidEntityException(Utilities.IDEGRESADONOTEMPTY);
		}
	}

	@Override
	public Long saveInfoControl(Map<String, String> entity) {
		InformacionControl informacionControl = new InformacionControl();
		if (entity.get(Utilities.IDINFORMACIONCONTROL).isEmpty()) {
			setCamposInfoControl(informacionControl, entity);
			businessDelegatorView.saveGeneric(informacionControl);
		} else {
			informacionControl = (InformacionControl) getInfoControlById(entity.get(Utilities.IDINFORMACIONCONTROL));
			if (informacionControl == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Informacion Control con Id %s", entity.get(Utilities.IDINFORMACIONCONTROL)));
			}
			setCamposInfoControl(informacionControl, entity);
			businessDelegatorView.updateGeneric(informacionControl);
		}
		return informacionControl.getIdInformacionControl();
	}

	private void setCamposInfoControl(InformacionControl informacionControl, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get(Utilities.IDEGRESADO))) {
			informacionControl.setIdEgresado(Long.parseLong(entity.get(Utilities.IDEGRESADO)));
		}
		if (Utilities.isNumeric(entity.get("fechaEntregaCarnet"))) {
			informacionControl.setFechaEntregaCarnet(new Date(Long.parseLong(entity.get("fechaEntregaCarnet"))));
		}
		if (Utilities.isNumeric(entity.get("encuestaM0En"))) {
			informacionControl.setEncuestaM0En(new Date(Long.parseLong(entity.get("encuestaM0En"))));
		}
		if (Utilities.isNumeric(entity.get("encuestaM1En"))) {
			informacionControl.setEncuestaM1En(new Date(Long.parseLong(entity.get("encuestaM1En"))));
		}
		if (Utilities.isNumeric(entity.get("encuestaM5En"))) {
			informacionControl.setEncuestaM5En(new Date(Long.parseLong(entity.get("encuestaM5En"))));
		}
		if (Utilities.isNumeric(entity.get("recibeInformacion"))) {
			informacionControl.setRecibeInformacion(Long.parseLong(entity.get("recibeInformacion")));
		}
		informacionControl.setGradoAcademusoft(entity.get("gradoAcademusoft"));
		informacionControl.setTipoInformacion(entity.get("tipoInformacion"));
		informacionControl.setObservacionCorreo(entity.get("observacionCorreo"));
		informacionControl.setObservacionesGenerales(entity.get("observacionesGenerales"));
		Iterator<ConstraintViolation<InformacionControl>> violations = Utilities.getValidator().validate(informacionControl).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public Map<String, Object> getAllInfoEgresado(String idEgresado) {
		Map<String, Object> response = new HashMap<>();
		response.put("Egresado", getEgresadoById(idEgresado));
		response.put("InformacionAcademica", getInfoAcademicaByIdEgresado(idEgresado));
		response.put("InformacionControl", getInfoControlByIdEgresado(idEgresado));
		return response;
	}

}
