package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface AporteInvestigacionService {

	List<Object> getAportes();

	Object getAporteById(String idAporteInvestigacion);

	Object saveAporteInvestigacion(Map<String, String> entity);

	List<Object> getEgresadoAporteByIdAporte(String idAporteInvestigacion);

	Object getEgresadoAporteById(String idEgresadoAporte);

	Object saveEgresadoAporte(Map<String, String> entity);

}
