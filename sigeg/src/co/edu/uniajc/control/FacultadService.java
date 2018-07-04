package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface FacultadService {

	List<Object> getFacultades();

	Object getFacultadById(String idFacultad);

	Object saveFacultad(Map<String, String> entity);

}
