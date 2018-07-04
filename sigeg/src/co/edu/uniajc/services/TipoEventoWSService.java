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

import co.edu.uniajc.control.TipoEventoServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class TipoEventoWSService {
	private static final Logger log = LoggerFactory.getLogger(TipoEventoWSService.class);

	@Autowired
	private TipoEventoServiceImpl service;

	@RequestMapping(value = "/getTiposEvento", method = RequestMethod.GET)
	public ResponseService getTiposEvento() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getTiposEvento());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getTipoEventoById", method = RequestMethod.POST)
	public ResponseService getTipoEventoById(@RequestParam String idTipoEvento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getTipoEventoById(idTipoEvento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveTipoEvento", method = RequestMethod.POST)
	public ResponseService saveTipoEvento(@RequestParam String idTipoEvento, @RequestParam String idCategoriaEvento, @RequestParam String nombre, @RequestParam String activo) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idTipoEvento", idTipoEvento);
			entity.put("idCategoriaEvento", idCategoriaEvento);
			entity.put("nombre", nombre);
			entity.put("activo", activo);
			responseService.setData(service.saveTipoEvento(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}
}
