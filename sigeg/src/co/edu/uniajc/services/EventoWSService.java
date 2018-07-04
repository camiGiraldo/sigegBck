package co.edu.uniajc.services;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniajc.control.EventoServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class EventoWSService {
	private static final Logger log = LoggerFactory.getLogger(EventoWSService.class);

	@Autowired
	private EventoServiceImpl service;

	@RequestMapping(value = "/getEventos", method = RequestMethod.GET)
	public ResponseService getEventos() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEventos());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getEventoById", method = RequestMethod.POST)
	public ResponseService getEventoById(@RequestParam String idEvento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEventoById(idEvento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveEvento", method = RequestMethod.POST)
	public ResponseService saveEvento(@RequestParam String idEvento, @RequestParam String idTipoEvento, @RequestParam String nombre, @RequestParam String fechaInicio, @RequestParam String fechaFin, @RequestParam String lugar, @RequestParam String horaInicio, @RequestParam String duracionEstimada, @RequestParam String costoEgresado,
			@RequestParam String costoUniajc, @RequestParam String certificable, @RequestParam String dependenciaOrganiza, @RequestParam String dependenciaBeneficiaria, @RequestParam String comunidadBeneficiaria, @RequestParam String personaACargo, @RequestParam String correoElectronico, @RequestParam String telefono,
			@RequestParam String cuposEgresados, @RequestParam String bannerEvento, @RequestParam String urlInscripcion, @RequestParam String adjunto, @RequestParam String soporte) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idEvento", idEvento);
			entity.put("idTipoEvento", idTipoEvento);
			entity.put("nombre", nombre);
			entity.put("fechaInicio", fechaInicio);
			entity.put("fechaFin", fechaFin);
			entity.put("lugar", lugar);
			entity.put("horaInicio", horaInicio);
			entity.put("duracionEstimada", duracionEstimada);
			entity.put("costoEgresado", costoEgresado);
			entity.put("costoUniajc", costoUniajc);
			entity.put("certificable", certificable);
			entity.put("dependenciaOrganiza", dependenciaOrganiza);
			entity.put("dependenciaBeneficiaria", dependenciaBeneficiaria);
			entity.put("comunidadBeneficiaria", comunidadBeneficiaria);
			entity.put("personaACargo", personaACargo);
			entity.put("correoElectronico", correoElectronico);
			entity.put("cuposEgresados", cuposEgresados);
			entity.put("bannerEvento", bannerEvento);
			entity.put("urlInscripcion", urlInscripcion);
			entity.put("adjunto", adjunto);
			entity.put("soporte", soporte);
			responseService.setData(service.saveEvento(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getAsistenciasByIdEvento", method = RequestMethod.POST)
	public ResponseService getAsistenciasByIdEvento(@RequestParam String idEvento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getAsistenciasByIdEvento(idEvento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(e.getMessage());
		}
		return responseService;
	}

	@RequestMapping(value = "/getAsistenciaEventoById", method = RequestMethod.POST)
	public ResponseService getAsistenciaEventoById(@RequestParam String idAsistenciaEvento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getAsistenciaEventoById(idAsistenciaEvento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveAsistenciaEvento", method = RequestMethod.POST)
	public ResponseService saveAsistenciaEvento(@RequestParam String idAsistenciaEvento, @RequestParam String idEgresado,
			@RequestParam String idEvento, @RequestParam String inscrito, @RequestParam String asistio, @RequestParam String aprobo) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idAsistenciaEvento", idAsistenciaEvento);
			entity.put("idEgresado", idEgresado);
			entity.put("idEvento", idEvento);
			entity.put("inscrito", inscrito);
			entity.put("asistio", asistio);
			entity.put("aprobo", aprobo);
			responseService.setData(service.saveAsistenciaEvento(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}
}
