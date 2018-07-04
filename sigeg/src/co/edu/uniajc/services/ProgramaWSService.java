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

import co.edu.uniajc.control.ProgramaServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class ProgramaWSService {

	private static final Logger log = LoggerFactory.getLogger(ProgramaWSService.class);
	@Autowired
	private ProgramaServiceImpl service;

	@RequestMapping(value = "/getProgramas", method = RequestMethod.GET)
	public ResponseService getProgramas() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getProgramas());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getProgramaById", method = RequestMethod.POST)
	public ResponseService getProgramaById(@RequestParam String idPrograma) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getProgramaById(idPrograma));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/savePrograma", method = RequestMethod.POST)
	public ResponseService savePrograma(String idPrograma, String idFacultad, String nombre, String abreviatura) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idPrograma", idPrograma);
			entity.put("idFacultad", idFacultad);
			entity.put("nombre", nombre);
			entity.put("abreviatura", abreviatura);
			responseService.setData(service.savePrograma(entity));
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
