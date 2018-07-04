package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface TipoEventoService {

	List<Object> getTiposEvento();

	Object getTipoEventoById(String idTipoEvento);

	Object saveTipoEvento(Map<String, String> entity);
}
