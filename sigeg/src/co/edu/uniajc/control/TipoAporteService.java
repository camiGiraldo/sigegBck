package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface TipoAporteService {

	List<Object> getTiposAporte();

	Object getTipoAporteById(String idTipoAporte);

	Object saveTipoAporte(Map<String, String> entity);

}
