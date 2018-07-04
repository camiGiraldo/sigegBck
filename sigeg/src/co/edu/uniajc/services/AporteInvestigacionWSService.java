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

import co.edu.uniajc.control.AporteInvestigacionServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class AporteInvestigacionWSService {
	private static final Logger log = LoggerFactory.getLogger(AporteInvestigacionWSService.class);

	@Autowired
	private AporteInvestigacionServiceImpl service;

	@RequestMapping(value = "/getAportes", method = RequestMethod.GET)
	public ResponseService getAportes() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getAportes());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getAporteById", method = RequestMethod.POST)
	public ResponseService getAporteById(@RequestParam String idAporteInvestigacion) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getAporteById(idAporteInvestigacion));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveAporte", method = RequestMethod.POST)
	public ResponseService saveAporte(@RequestParam String idAporteInvestigacion, @RequestParam String idTipoAporte, @RequestParam String fechaRealizacion, @RequestParam String fechaFinalizacion, @RequestParam String grupoBeneficiario, @RequestParam String subGrupoBeneficiario, @RequestParam String nombreProyecto,
			@RequestParam String descripcionProyecto, @RequestParam String personaACargo, @RequestParam String correoElectronico, @RequestParam String telefono, @RequestParam String adjunto) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idAporteInvestigacion", idAporteInvestigacion);
			entity.put("idTipoAporte", idTipoAporte);
			entity.put("fechaRealizacion", fechaRealizacion);
			entity.put("fechaFinalizacion", fechaFinalizacion);
			entity.put("grupoBeneficiario", grupoBeneficiario);
			entity.put("subGrupoBeneficiario", subGrupoBeneficiario);
			entity.put("nombreProyecto", nombreProyecto);
			entity.put("descripcionProyecto", descripcionProyecto);
			entity.put("personaACargo", personaACargo);
			entity.put("correoElectronico", correoElectronico);
			entity.put("telefono", telefono);
			entity.put("adjunto", adjunto);
			responseService.setData(service.saveAporteInvestigacion(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getEgresadoAporteByIdAporte", method = RequestMethod.POST)
	public ResponseService getEgresadoAporteByIdAporte(@RequestParam String idAporteInvestigacion) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEgresadoAporteByIdAporte(idAporteInvestigacion));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}

		return responseService;
	}

	@RequestMapping(value = "/getEgresadoAporteById", method = RequestMethod.POST)
	public ResponseService getEgresadoAporteById(@RequestParam String idEgresadoAporte) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEgresadoAporteById(idEgresadoAporte));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveEgresadoAporte", method = RequestMethod.POST)
	public ResponseService saveEgresadoAporte(@RequestParam String idEgresadoAporte, @RequestParam String idAporteInvestigacion, @RequestParam String idEgresado,
			@RequestParam String participacion, @RequestParam String urlExterna, @RequestParam String soporte) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idEgresadoAporte", idEgresadoAporte);
			entity.put("idAporteInvestigacion", idAporteInvestigacion);
			entity.put("idEgresado", idEgresado);
			entity.put("participacion", participacion);
			entity.put("urlExterna", urlExterna);
			entity.put("soporte", soporte);
			responseService.setData(service.saveEgresadoAporte(entity));
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
