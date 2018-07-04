package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface ParticipacionDemocraticaService {

	List<Object> getParticipaciones();

	Object getParticipacionById(String idParticipacionDemocratica);

	Object saveParticipacion(Map<String, String> entity);

	List<Object> getParticipacionesEgresadoByIdParticipacion(String idParticipacionDemocratica);

	Object getParticipacionEgresadoById(String idParticipacionEgresado);

	Object saveParticipacionEgresado(Map<String, String> entity);

}
