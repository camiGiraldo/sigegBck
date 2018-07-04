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

import co.edu.uniajc.control.TipoAporteServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class TipoAporteWSService {
	private static final Logger log = LoggerFactory.getLogger(TipoAporteWSService.class);

	@Autowired
	private TipoAporteServiceImpl service;

	@RequestMapping(value = "/getTiposAporte", method = RequestMethod.GET)
	public ResponseService getTiposAporte() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getTiposAporte());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getTipoAporteById", method = RequestMethod.POST)
	public ResponseService getTipoAporteById(@RequestParam String idTipoAporte) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getTipoAporteById(idTipoAporte));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveTipoAporte", method = RequestMethod.POST)
	public ResponseService saveTipoAporte(@RequestParam String idTipoAporte, @RequestParam String nombre, @RequestParam String activo) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idTipoAporte", idTipoAporte);
			entity.put("nombre", nombre);
			entity.put("activo", activo);
			responseService.setData(service.saveTipoAporte(entity));
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
