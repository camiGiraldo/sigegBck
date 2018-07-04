package co.edu.uniajc.control;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.AsistenciaEvento;
import co.edu.dataaccess.dao.Evento;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getEventos() {
		return businessDelegatorView.getAllEntities(Evento.class);
	}

	@Override
	public Object getEventoById(String idEvento) {
		if (!idEvento.isEmpty() && Utilities.isNumeric(idEvento)) {
			return businessDelegatorView.getEntityById(Evento.class, Long.parseLong(idEvento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Evento no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Long saveEvento(Map<String, String> entity) {
		Evento evento = new Evento();
		if (entity.get(Utilities.IDEVENTO).isEmpty()) {
			setCamposEvento(evento, entity);
			businessDelegatorView.saveGeneric(evento);
		} else {
			evento = (Evento) getEventoById(entity.get(Utilities.IDEVENTO));
			if (evento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Evento con Id %s", entity.get(Utilities.IDEVENTO)));
			}
			setCamposEvento(evento, entity);
			businessDelegatorView.updateGeneric(evento);
		}
		return evento.getIdEvento();
	}

	private void setCamposEvento(Evento evento, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get("idTipoEvento"))) {
			evento.setIdTipoEvento(Long.parseLong(entity.get("idTipoEvento")));
		}
		evento.setNombre(entity.get("nombre"));
		if (Utilities.isNumeric(entity.get("fechaInicio"))) {
			evento.setFechaInicio(new Date(Long.parseLong(entity.get("fechaInicio"))));
		}
		if (Utilities.isNumeric(entity.get("fechaFin"))) {
			evento.setFechaFin(new Date(Long.parseLong(entity.get("fechaFin"))));
		}
		evento.setLugar(entity.get("lugar"));
		evento.setHoraInicio(entity.get("horaInicio"));
		evento.setDuracionEstimada(entity.get("duracionEstimada"));
		if (Utilities.isNumeric(entity.get("costoEgresado"))) {
			evento.setCostoEgresado(Long.parseLong(entity.get("costoEgresado")));
		}
		if (Utilities.isNumeric(entity.get("costoUniajc"))) {
			evento.setCostoUniajc(Long.parseLong(entity.get("costoUniajc")));
		}
		if (Utilities.isNumeric(entity.get("certificable"))) {
			evento.setCertificable(Long.parseLong(entity.get("certificable")));
		}
		evento.setDependenciaOrganiza(entity.get("dependenciaOrganiza"));
		evento.setDependenciaBeneficiaria(entity.get("dependenciaBeneficiaria"));
		evento.setComunidadBeneficiaria(entity.get("comunidadBeneficiaria"));
		evento.setPersonaACargo(entity.get("personaACargo"));
		evento.setCorreoElectronico(entity.get("correoElectronico"));
		evento.setTelefono(entity.get("telefono"));
		if (Utilities.isNumeric(entity.get("cuposEgresados"))) {
			evento.setCuposEgresados(Long.parseLong(entity.get("cuposEgresados")));
		}
		if (Utilities.isNumeric(entity.get("bannerEvento"))) {
			evento.setBannerEvento(Long.parseLong(entity.get("bannerEvento")));
		}
		evento.setUrlInscripcion(entity.get("urlInscripcion"));
		evento.setUrlExterna(entity.get("urlExterna"));
		if (Utilities.isNumeric(entity.get("soporte"))) {
			evento.setSoporte(Long.parseLong(entity.get("soporte")));
		}
		if (evento.getIdEvento() == null) {
			evento.setFechaCreacion(new Date(System.currentTimeMillis()));
		}
		Iterator<ConstraintViolation<Evento>> violations = Utilities.getValidator().validate(evento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

	@Override
	public List<Object> getAsistenciasByIdEvento(String idEvento) {
		if (!idEvento.isEmpty() && Utilities.isNumeric(idEvento)) {
			return businessDelegatorView.getFindCriteriaGeneric(AsistenciaEvento.class, "IdEvento = ?1", new Object[] { Long.parseLong(idEvento) });
		} else {
			throw new ZMessManager.InvalidEntityException("Id Evento obligatorio y debe ser un numero");
		}
	}

	@Override
	public Object getAsistenciaEventoById(String idAsistenciaEvento) {
		if (!idAsistenciaEvento.isEmpty() && Utilities.isNumeric(idAsistenciaEvento)) {
			return businessDelegatorView.getEntityById(AsistenciaEvento.class, Long.parseLong(idAsistenciaEvento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Object saveAsistenciaEvento(Map<String, String> entity) {
		AsistenciaEvento asistenciaEvento = new AsistenciaEvento();
		if (entity.get(Utilities.IDASISTENCIAEVENTO).isEmpty()) {
			setCamposAsistenciaEvento(asistenciaEvento, entity);
			businessDelegatorView.saveGeneric(asistenciaEvento);
		} else {
			asistenciaEvento = (AsistenciaEvento) getAsistenciaEventoById(entity.get(Utilities.IDASISTENCIAEVENTO));
			if (asistenciaEvento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Asistencia Evento con Id %s", entity.get(Utilities.IDASISTENCIAEVENTO)));
			}
			setCamposAsistenciaEvento(asistenciaEvento, entity);
			businessDelegatorView.updateGeneric(asistenciaEvento);
		}
		return asistenciaEvento.getIdAsistenciaEvento();
	}

	private void setCamposAsistenciaEvento(AsistenciaEvento asistenciaEvento, Map<String, String> entity) {
		if (Utilities.isNumeric(entity.get("idEgresado"))) {
			asistenciaEvento.setIdEgresado(Long.parseLong(entity.get("idEgresado")));
		}
		if (Utilities.isNumeric(entity.get(Utilities.IDEVENTO))) {
			asistenciaEvento.setIdEvento(Long.parseLong(entity.get(Utilities.IDEVENTO)));
		}
		if (Utilities.isNumeric(entity.get("inscrito"))) {
			asistenciaEvento.setInscrito(Long.parseLong(entity.get("inscrito")));
		}
		if (Utilities.isNumeric(entity.get("asistio"))) {
			asistenciaEvento.setAsistio(Long.parseLong(entity.get("asistio")));
		}
		if (Utilities.isNumeric(entity.get("aprobo"))) {
			asistenciaEvento.setAprobo(Long.parseLong(entity.get("aprobo")));
		}
		Iterator<ConstraintViolation<AsistenciaEvento>> violations = Utilities.getValidator().validate(asistenciaEvento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
