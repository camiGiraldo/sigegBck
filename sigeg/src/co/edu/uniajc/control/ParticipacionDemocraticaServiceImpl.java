package co.edu.uniajc.control;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.ParticipacionDemocratica;
import co.edu.dataaccess.dao.ParticipacionEgresado;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class ParticipacionDemocraticaServiceImpl implements ParticipacionDemocraticaService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getParticipaciones() {
		return businessDelegatorView.getAllEntities(ParticipacionDemocratica.class);
	}

	@Override
	public Object getParticipacionById(String idParticipacionDemocratica) {
		if (!idParticipacionDemocratica.isEmpty() && Utilities.isNumeric(idParticipacionDemocratica) && idParticipacionDemocratica.length() <= 10) {
			return businessDelegatorView.getEntityById(ParticipacionDemocratica.class, Long.parseLong(idParticipacionDemocratica));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Participacion no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Object saveParticipacion(Map<String, String> entity) {
		ParticipacionDemocratica participacion = new ParticipacionDemocratica();
		if (entity.get(Utilities.IDPARTICIPACIONDEMOCRATICA).isEmpty()) {
			setCamposParticipacion(participacion, entity);
			businessDelegatorView.saveGeneric(participacion);
		} else {
			participacion = (ParticipacionDemocratica) getParticipacionById(entity.get(Utilities.IDPARTICIPACIONDEMOCRATICA));
			if (participacion == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Participacion Democratica con Id %s", entity.get(Utilities.IDPARTICIPACIONDEMOCRATICA)));
			}
			setCamposParticipacion(participacion, entity);
			businessDelegatorView.updateGeneric(participacion);
		}
		return participacion.getIdParticipacionDemocratica();

	}

	private void setCamposParticipacion(ParticipacionDemocratica participacion, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get("idFormaParticipacion"))) {
			participacion.setIdFormaParticipacion(Long.parseLong(entity.get("idFormaParticipacion")));
		}
		participacion.setOrganoGremial(entity.get("organoGremial"));

		if (Utilities.isNumeric(entity.get("fechaInscripcion"))) {
			participacion.setFechaInscripcion(new Date(Long.parseLong(entity.get("fechaInscripcion"))));
		}

		if (Utilities.isNumeric(entity.get("fechaEleccion"))) {
			participacion.setFechaEleccion(new Date(Long.parseLong(entity.get("fechaEleccion"))));
		}

		participacion.setVigencia(entity.get("vigencia"));

		if (Utilities.isNumeric(entity.get("fechaLimite"))) {
			participacion.setFechaLimite(new Date(Long.parseLong(entity.get("fechaLimite"))));
		}

		participacion.setDependenciaSupervisa(entity.get("dependenciaSupervisa"));
		participacion.setPersonaACargo(entity.get("personaACargo"));
		participacion.setCorreoElectronico(entity.get("correoElectronico"));
		participacion.setTelefono(entity.get("telefono"));
		participacion.setEnlaceVotaciones(entity.get("enlaceVotaciones"));
		if (participacion.getIdParticipacionDemocratica() == null) {
			participacion.setFechaCreacion(new Date(System.currentTimeMillis()));
		}
		Iterator<ConstraintViolation<ParticipacionDemocratica>> violations = Utilities.getValidator().validate(participacion).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public List<Object> getParticipacionesEgresadoByIdParticipacion(String idParticipacionDemocratica) {
		if (!idParticipacionDemocratica.isEmpty() && Utilities.isNumeric(idParticipacionDemocratica) && idParticipacionDemocratica.length() <= 10) {
			return businessDelegatorView.getFindCriteriaGeneric(ParticipacionEgresado.class, "IdParticipacionDemocratica = ?1 ", new Object[] { Long.parseLong(idParticipacionDemocratica) });
		} else {
			throw new ZMessManager.InvalidEntityException("Id Participacion no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Object getParticipacionEgresadoById(String idParticipacionEgresado) {
		if (!idParticipacionEgresado.isEmpty() && Utilities.isNumeric(idParticipacionEgresado) && idParticipacionEgresado.length() <= 10) {
			return businessDelegatorView.getEntityById(ParticipacionEgresado.class, Long.parseLong(idParticipacionEgresado));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Participacion Egresado no puede estar vacio y debe ser un numero con menos de 10 caracteres");
		}
	}

	@Override
	public Long saveParticipacionEgresado(Map<String, String> entity) {
		ParticipacionEgresado participacion = new ParticipacionEgresado();
		if (entity.get(Utilities.IDPARTICIPACIONEGRESADO).isEmpty()) {
			setCamposParticipacionEgresado(participacion, entity);
			businessDelegatorView.saveGeneric(participacion);
		} else {
			participacion = (ParticipacionEgresado) getParticipacionEgresadoById(entity.get(Utilities.IDPARTICIPACIONEGRESADO));
			if (participacion == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Participacion Egresado con Id %s", entity.get(Utilities.IDPARTICIPACIONEGRESADO)));
			}
			setCamposParticipacionEgresado(participacion, entity);
			businessDelegatorView.updateGeneric(participacion);
		}
		return participacion.getIdParticipacionEgresado();
	}

	private void setCamposParticipacionEgresado(ParticipacionEgresado participacion, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get(Utilities.IDPARTICIPACIONDEMOCRATICA))) {
			participacion.setIdParticipacionDemocratica(Long.parseLong(entity.get(Utilities.IDPARTICIPACIONDEMOCRATICA)));
		}
		if (Utilities.isNumeric(entity.get("idEgresado"))) {
			participacion.setIdEgresado(Long.parseLong(entity.get("idEgresado")));
		}
		if (Utilities.isNumeric(entity.get("inscrito"))) {
			participacion.setInscrito(Long.parseLong(entity.get("inscrito")));
		}
		if (Utilities.isNumeric(entity.get("elegido"))) {
			participacion.setElegido(Long.parseLong(entity.get("elegido")));
		}
		if (Utilities.isNumeric(entity.get("socioFundador"))) {
			participacion.setSocioFundador(Long.parseLong(entity.get("socioFundador")));
		}
		if (Utilities.isNumeric(entity.get("socioAdherente"))) {
			participacion.setSocioAdherente(Long.parseLong(entity.get("socioAdherente")));
		}
		if (Utilities.isNumeric(entity.get("beneficiario"))) {
			participacion.setBeneficiario(Long.parseLong(entity.get("beneficiario")));
		}
		Iterator<ConstraintViolation<ParticipacionEgresado>> violations = Utilities.getValidator().validate(participacion).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
