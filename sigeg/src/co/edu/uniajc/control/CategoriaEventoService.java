package co.edu.uniajc.control;

import java.util.List;
import java.util.Map;

public interface CategoriaEventoService {

	List<Object> getCategoriasEvento();

	Object getCategoriaEventoById(String idCategoriaEvento);

	Object saveCategoriaEvento(Map<String, String> entity);

}
