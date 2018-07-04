package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface TipoReconocimientoService {

	List<Object> getTiposReconocimiento();

	Object getTipoReconocimientoById(String idTipoReconocimiento);

	Object saveTipoReconocimiento(Map<String, String> entity);

}
