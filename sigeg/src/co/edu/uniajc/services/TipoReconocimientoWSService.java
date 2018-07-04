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

import co.edu.uniajc.control.TipoReconocimientoServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class TipoReconocimientoWSService {
	private static final Logger log = LoggerFactory.getLogger(TipoReconocimientoWSService.class);

	@Autowired
	private TipoReconocimientoServiceImpl service;

	@RequestMapping(value = "/getTiposReconocimiento", method = RequestMethod.GET)
	public ResponseService getTiposReconocimiento() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getTiposReconocimiento());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getTipoReconocimientoById", method = RequestMethod.POST)
	public ResponseService getTipoReconocimientoById(@RequestParam String idTipoReconocimiento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getTipoReconocimientoById(idTipoReconocimiento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveTipoReconocimiento", method = RequestMethod.POST)
	public ResponseService saveTipoReconocimiento(@RequestParam String idTipoReconocimiento, @RequestParam String nombre, @RequestParam String activo) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idTipoReconocimiento", idTipoReconocimiento);
			entity.put("nombre", nombre);
			entity.put("activo", activo);
			responseService.setData(service.saveTipoReconocimiento(entity));
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
