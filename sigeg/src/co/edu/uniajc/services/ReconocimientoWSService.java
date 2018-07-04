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

import co.edu.uniajc.control.ReconocimientoServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class ReconocimientoWSService {
	private static final Logger log = LoggerFactory.getLogger(ReconocimientoWSService.class);

	@Autowired
	private ReconocimientoServiceImpl service;

	@RequestMapping(value = "/getReconocimientos", method = RequestMethod.GET)
	public ResponseService getReconocimientos() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getReconocimientos());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getReconocimientoById", method = RequestMethod.POST)
	public ResponseService getReconocimientoById(@RequestParam String idReconocimiento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getReconocimientoById(idReconocimiento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveReconocimiento", method = RequestMethod.POST)
	public ResponseService saveReconocimiento(@RequestParam String idReconocimiento, @RequestParam String idTipoReconocimiento, @RequestParam String adjunto,
			@RequestParam String fechaVinculacion, @RequestParam String lugarRealizacion, @RequestParam String beneficiario, @RequestParam String descripcion,
			@RequestParam String soporte) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idReconocimiento", idReconocimiento);
			entity.put("idTipoReconocimiento", idTipoReconocimiento);
			entity.put("adjunto", adjunto);
			entity.put("fechaVinculacion", fechaVinculacion);
			entity.put("lugarRealizacion", lugarRealizacion);
			entity.put("beneficiario", beneficiario);
			entity.put("descripcion", descripcion);
			entity.put("soporte", soporte);
			responseService.setData(service.saveReconocimiento(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getEgresadoReconocimientosByIdReconocimiento", method = RequestMethod.POST)
	public ResponseService getEgresadoReconocimientosByIdReconocimiento(@RequestParam String idReconocimiento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEgresadoReconocimientosByIdReconocimiento(idReconocimiento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getEgresadoReconocimientoById", method = RequestMethod.POST)
	public ResponseService getEgresadoReconocimientoById(@RequestParam String idEgresadoReconocimiento) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEgresadoReconocimientoById(idEgresadoReconocimiento));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveEgresadoReconocimiento", method = RequestMethod.POST)
	public ResponseService saveEgresadoReconocimiento(@RequestParam String idEgresadoReconocimiento, @RequestParam String idReconocimiento, @RequestParam String idEgresado,
			@RequestParam String distinguido, @RequestParam String vinculadoLaboralmente, @RequestParam String logroPublicado, @RequestParam String urlExterna,
			@RequestParam String soporte) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idEgresadoReconocimiento", idEgresadoReconocimiento);
			entity.put("idReconocimiento", idReconocimiento);
			entity.put("idEgresado", idEgresado);
			entity.put("distinguido", distinguido);
			entity.put("vinculadoLaboralmente", vinculadoLaboralmente);
			entity.put("logroPublicado", logroPublicado);
			entity.put("urlExterna", urlExterna);
			entity.put("soporte", soporte);
			responseService.setData(service.saveEgresadoReconocimiento(entity));
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
