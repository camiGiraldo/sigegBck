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

import co.edu.uniajc.control.FormaParticipacionServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class FormaParticipacionWSService {
	private static final Logger log = LoggerFactory.getLogger(FormaParticipacionWSService.class);

	@Autowired
	private FormaParticipacionServiceImpl service;

	@RequestMapping(value = "/getFormasParticipacion", method = RequestMethod.GET)
	public ResponseService getFormasParticipacion() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getFormasParticipacion());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getFormaParticipacionById", method = RequestMethod.POST)
	public ResponseService getFormaParticipacionById(@RequestParam String idFormaParticipacion) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getFormaParticipacionById(idFormaParticipacion));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveFormaParticipacion", method = RequestMethod.POST)
	public ResponseService saveFormaParticipacion(@RequestParam String idFormaParticipacion, @RequestParam String nombre, @RequestParam String activo) {
		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idFormaParticipacion", idFormaParticipacion);
			entity.put("nombre", nombre);
			entity.put("activo", activo);
			responseService.setData(service.saveFormaParticipacion(entity));
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
