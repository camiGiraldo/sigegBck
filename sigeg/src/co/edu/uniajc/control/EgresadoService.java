package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface EgresadoService {

	List<Object> getEgresados();

	Object getEgresadoById(String idEgresado);

	Object saveEgresado(Map<String, String> entity);

	Object getInfoAcademicaById(String idInformacionAcademica);

	List<Object> getInfoAcademicaByIdEgresado(String idEgresado);

	Object saveInfoAcademica(Map<String, String> entity);

	Object getInfoControlById(String idInformacionControl);

	List<Object> getInfoControlByIdEgresado(String idEgresado);

	Object saveInfoControl(Map<String, String> entity);

	Map<String, Object> getAllInfoEgresado(String idEgresado);

}
