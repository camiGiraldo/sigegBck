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

import co.edu.uniajc.control.CategoriaEventoServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class CategoriaEventoWSService {
	private static final Logger log = LoggerFactory.getLogger(CategoriaEventoWSService.class);

	@Autowired
	private CategoriaEventoServiceImpl service;

	@RequestMapping(value = "/getCategoriasEvento", method = RequestMethod.GET)
	public ResponseService getCategoriasEvento() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getCategoriasEvento());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getCategoriaEventoById", method = RequestMethod.POST)
	public ResponseService getCategoriaEventoById(@RequestParam String idCategoriaEvento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getCategoriaEventoById(idCategoriaEvento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveCategoriaEvento", method = RequestMethod.POST)
	public ResponseService saveCategoriaEvento(@RequestParam String idCategoriaEvento, @RequestParam String nombre, @RequestParam String activo) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idCategoriaEvento", idCategoriaEvento);
			entity.put("nombre", nombre);
			entity.put("activo", activo);
			responseService.setData(service.saveCategoriaEvento(entity));
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
