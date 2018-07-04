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

import co.edu.uniajc.control.ParticipacionDemocraticaServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class ParticipacionDemocraticaWSService {
	private static final Logger log = LoggerFactory.getLogger(ParticipacionDemocraticaWSService.class);

	@Autowired
	private ParticipacionDemocraticaServiceImpl service;

	@RequestMapping(value = "/getParticipaciones", method = RequestMethod.GET)
	public ResponseService getParticipaciones() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getParticipaciones());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getParticipacionById", method = RequestMethod.POST)
	public ResponseService getParticipacionById(@RequestParam String idParticipacionDemocratica) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getParticipacionById(idParticipacionDemocratica));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveParticipacion", method = RequestMethod.POST)
	public ResponseService saveParticipacion(@RequestParam String idParticipacionDemocratica, @RequestParam String idFormaParticipacion, @RequestParam String organoGremial,
			@RequestParam String fechaInscripcion, @RequestParam String fechaEleccion, @RequestParam String vigencia, @RequestParam String fechaLimite,
			@RequestParam String dependenciaSupervisa, @RequestParam String personaACargo, @RequestParam String correoElectronico,
			@RequestParam String telefono, @RequestParam String enlaceVotaciones) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idParticipacionDemocratica", idParticipacionDemocratica);
			entity.put("idFormaParticipacion", idFormaParticipacion);
			entity.put("organoGremial", organoGremial);
			entity.put("fechaInscripcion", fechaInscripcion);
			entity.put("fechaEleccion", fechaEleccion);
			entity.put("vigencia", vigencia);
			entity.put("fechaLimite", fechaLimite);
			entity.put("dependenciaSupervisa", dependenciaSupervisa);
			entity.put("personaACargo", personaACargo);
			entity.put("correoElectronico", correoElectronico);
			entity.put("telefono", telefono);
			entity.put("enlaceVotaciones", enlaceVotaciones);
			responseService.setData(service.saveParticipacion(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getParticipacionesEgresadoByIdParticipacion", method = RequestMethod.POST)
	public ResponseService getParticipacionesEgresadoByIdParticipacion(@RequestParam String idParticipacionDemocratica) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getParticipacionesEgresadoByIdParticipacion(idParticipacionDemocratica));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveParticipacionEgresado", method = RequestMethod.POST)
	public ResponseService saveParticipacionEgresado(@RequestParam String idParticipacionEgresado, @RequestParam String idParticipacionDemocratica, @RequestParam String idEgresado,
			@RequestParam String inscrito, @RequestParam String elegido, @RequestParam String socioFundador, @RequestParam String socioAdherente,
			@RequestParam String beneficiario) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idParticipacionEgresado", idParticipacionEgresado);
			entity.put("idParticipacionDemocratica", idParticipacionDemocratica);
			entity.put("idEgresado", idEgresado);
			entity.put("inscrito", inscrito);
			entity.put("elegido", elegido);
			entity.put("socioFundador", socioFundador);
			entity.put("socioAdherente", socioAdherente);
			entity.put("beneficiario", beneficiario);
			responseService.setData(service.saveParticipacionEgresado(entity));
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
