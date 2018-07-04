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

import co.edu.uniajc.control.FacultadServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class FacultadWSService {
	private static final Logger log = LoggerFactory.getLogger(FacultadWSService.class);

	@Autowired
	private FacultadServiceImpl service;

	@RequestMapping(value = "/getFacultades", method = RequestMethod.GET)
	public ResponseService getFacultades() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getFacultades());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getFacultadById", method = RequestMethod.POST)
	public ResponseService getFacultadById(@RequestParam String idFacultad) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getFacultadById(idFacultad));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveFacultad", method = RequestMethod.POST)
	public ResponseService saveFacultad(@RequestParam String idFacultad, @RequestParam String nombre, @RequestParam String abreviatura) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idFacultad", idFacultad);
			entity.put("nombre", nombre);
			entity.put("abreviatura", abreviatura);
			responseService.setStatus(Status.OK);
			responseService.setData(service.saveFacultad(entity));
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}
}
