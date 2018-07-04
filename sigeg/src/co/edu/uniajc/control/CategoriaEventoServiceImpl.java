package co.edu.uniajc.control;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.dao.CategoriaEvento;
import co.edu.delegate.BusinessDelegatorView;
import co.edu.exceptions.ZMessManager;
import co.edu.utilities.Utilities;

@Service
public class CategoriaEventoServiceImpl implements CategoriaEventoService {

	@Autowired
	private BusinessDelegatorView businessDelegatorView;

	@Override
	public List<Object> getCategoriasEvento() {
		return businessDelegatorView.getAllEntities(CategoriaEvento.class);
	}

	@Override
	public Object getCategoriaEventoById(String idCategoriaEvento) {
		if (!idCategoriaEvento.isEmpty() && Utilities.isNumeric(idCategoriaEvento)) {
			return businessDelegatorView.getEntityById(CategoriaEvento.class, Long.parseLong(idCategoriaEvento));
		} else {
			throw new ZMessManager.InvalidEntityException("Id Categoria no puede estar vacio y debe ser un numero");
		}
	}

	@Override
	public Object saveCategoriaEvento(Map<String, String> entity) {
		CategoriaEvento categoriaEvento = new CategoriaEvento();
		if (entity.get(Utilities.IDCATEGORIAEVENTO).isEmpty()) {
			setCamposCategoria(categoriaEvento, entity);
			businessDelegatorView.saveGeneric(categoriaEvento);
		} else {
			categoriaEvento = (CategoriaEvento) getCategoriaEventoById(entity.get(Utilities.IDCATEGORIAEVENTO));
			if (categoriaEvento == null) {
				throw new ZMessManager.InvalidEntityException(String.format("No existe Categoria Evento con Id %s", entity.get(Utilities.IDCATEGORIAEVENTO)));
			}
			setCamposCategoria(categoriaEvento, entity);
			businessDelegatorView.updateGeneric(categoriaEvento);
		}
		return categoriaEvento.getIdCategoriaEvento();
	}

	private void setCamposCategoria(CategoriaEvento categoriaEvento, Map<String, String> entity) {
		categoriaEvento.setNombre(entity.get("nombre"));
		if (Utilities.isNumeric(entity.get("activo"))) {
			categoriaEvento.setActivo(Long.parseLong(entity.get("activo")));
		}
		Iterator<ConstraintViolation<CategoriaEvento>> violations = Utilities.getValidator().validate(categoriaEvento).iterator();
		if (violations.hasNext()) {
			throw new ZMessManager.InvalidEntityException(violations.next().getMessage());
		}
	}

}
