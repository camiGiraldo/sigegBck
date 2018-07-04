package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface ReconocimientoService {

	List<Object> getReconocimientos();

	Object getReconocimientoById(String idReconocimiento);

	Object saveReconocimiento(Map<String, String> entity);

	List<Object> getEgresadoReconocimientosByIdReconocimiento(String idReconocimiento);

	Object getEgresadoReconocimientoById(String idEgresadoReconocimiento);

	Object saveEgresadoReconocimiento(Map<String, String> entity);

}
