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

import co.edu.uniajc.control.EgresadoServiceImpl;
import co.edu.utilities.ResponseService;
import co.edu.utilities.Status;
import co.edu.utilities.Utilities;

@CrossOrigin
@RestController
public class EgresadoWSService {
	private static final Logger log = LoggerFactory.getLogger(FacultadWSService.class);

	@Autowired
	private EgresadoServiceImpl service;

	@RequestMapping(value = "/getEgresados", method = RequestMethod.GET)
	public ResponseService getEgresados() {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEgresados());
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getEgresadoById", method = RequestMethod.POST)
	public ResponseService getEgresadoById(@RequestParam String idEgresado) {

		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getEgresadoById(idEgresado));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveEgresado", method = RequestMethod.POST)
	public ResponseService saveEgresado(@RequestParam String idEgresado, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String tipoIdentificacion, @RequestParam String identificacion, @RequestParam String ciudadExpedicion, @RequestParam String paisResidencia, @RequestParam String ciudadResidencia,
			@RequestParam String direccionResidencia, @RequestParam String telefonoFijo, @RequestParam String telefonoMovil, @RequestParam String telefonoMovilAlterno, @RequestParam String correoElectronico, @RequestParam String correoElectronicoAlterno) {

		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put(Utilities.IDEGRESADO, idEgresado);
			entity.put("nombres", nombres);
			entity.put("apellidos", apellidos);
			entity.put("tipoIdentificacion", tipoIdentificacion);
			entity.put("identificacion", identificacion);
			entity.put("ciudadExpedicion", ciudadExpedicion);
			entity.put("paisResidencia", paisResidencia);
			entity.put("ciudadResidencia", ciudadResidencia);
			entity.put("direccionResidencia", direccionResidencia);
			entity.put("telefonoFijo", telefonoFijo);
			entity.put("telefonoMovil", telefonoMovil);
			entity.put("telefonoMovilAlterno", telefonoMovilAlterno);
			entity.put("correoElectronico", correoElectronico);
			entity.put("correoElectronicoAlterno", correoElectronicoAlterno);
			responseService.setData(service.saveEgresado(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveInformacionAcademica", method = RequestMethod.POST)
	public ResponseService saveInformacionAcademica(@RequestParam String idInformacionAcademica, @RequestParam String idEgresado, @RequestParam String idPrograma, @RequestParam String libro, @RequestParam String folio, @RequestParam String acta, @RequestParam String numeroDiploma, @RequestParam String semestreGrado, @RequestParam String formaGrado,
			@RequestParam String tipoOpcionGrado, @RequestParam String notaOpcionGrado, @RequestParam String semestreFinalizoMaterias) {
		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idInformacionAcademica", idInformacionAcademica);
			entity.put(Utilities.IDEGRESADO, idEgresado);
			entity.put("idPrograma", idPrograma);
			entity.put("libro", libro);
			entity.put("folio", folio);
			entity.put("acta", acta);
			entity.put("numeroDiploma", numeroDiploma);
			entity.put("semestreGrado", semestreGrado);
			entity.put("formaGrado", formaGrado);
			entity.put("tipoOpcionGrado", tipoOpcionGrado);
			entity.put("notaOpcionGrado", notaOpcionGrado);
			entity.put("semestreFinalizoMaterias", semestreFinalizoMaterias);
			responseService.setData(service.saveInfoAcademica(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/saveInformacionControl", method = RequestMethod.POST)
	public ResponseService saveInformacionControl(@RequestParam String idInformacionControl, @RequestParam String idEgresado, @RequestParam String fechaEntregaCarnet, @RequestParam String encuestaM0En, @RequestParam String encuestaM1En, @RequestParam String encuestaM5En, @RequestParam String gradoAcademusoft,
			@RequestParam String recibeInformacion, @RequestParam String tipoInformacion, @RequestParam String observacionCorreo, @RequestParam String observacionesGenerales) {
		ResponseService responseService = new ResponseService();
		Map<String, String> entity;
		try {
			entity = new HashMap<>();
			entity.put("idInformacionControl", idInformacionControl);
			entity.put(Utilities.IDEGRESADO, idEgresado);
			entity.put("fechaEntregaCarnet", fechaEntregaCarnet);
			entity.put("encuestaM0En", encuestaM0En);
			entity.put("encuestaM1En", encuestaM1En);
			entity.put("encuestaM5En", encuestaM5En);
			entity.put("gradoAcademusoft", gradoAcademusoft);
			entity.put("recibeInformacion", recibeInformacion);
			entity.put("tipoInformacion", tipoInformacion);
			entity.put("observacionCorreo", observacionCorreo);
			entity.put("observacionesGenerales", observacionesGenerales);
			responseService.setData(service.saveInfoControl(entity));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORSAVE);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORSAVE, e);
		}
		return responseService;
	}

	@RequestMapping(value = "/getAllInfoEgresado", method = RequestMethod.POST)
	public ResponseService getAllInfoEgresado(@RequestParam String idEgresado) {
		ResponseService responseService = new ResponseService();
		try {
			responseService.setData(service.getAllInfoEgresado(idEgresado));
			responseService.setStatus(Status.OK);
		} catch (Exception e) {
			responseService.setStatus(Status.FAILURE);
			responseService.setMessage(Utilities.ERRORGET);
			responseService.setCodeError(e.getMessage());
			log.error(Utilities.ERRORGET, e);
		}
		return responseService;
	}

}
