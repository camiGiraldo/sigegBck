package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface FormaParticipacionService {

	List<Object> getFormasParticipacion();

	Object getFormaParticipacionById(String idFormaParticipacion);

	Object saveFormaParticipacion(Map<String, String> entity);

}
