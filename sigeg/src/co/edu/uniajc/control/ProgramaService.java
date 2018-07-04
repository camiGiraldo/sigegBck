package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface ProgramaService {

	List<Object> getProgramas();

	Object getProgramaById(String idPrograma);

	Object savePrograma(Map<String, String> entity);

}
