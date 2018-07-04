package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface EventoService {

	List<Object> getEventos();

	Object getEventoById(String idEvento);

	Object saveEvento(Map<String, String> entity);

	List<Object> getAsistenciasByIdEvento(String idEvento);

	Object getAsistenciaEventoById(String idAsistenciaEvento);

	Object saveAsistenciaEvento(Map<String, String> entity);

}
