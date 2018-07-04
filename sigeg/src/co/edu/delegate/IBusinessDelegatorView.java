package co.edu.delegate;

import java.util.List;

public interface IBusinessDelegatorView {

	public void saveGeneric(Object entity);

	public void updateGeneric(Object entity);

	public List<Object> getAllEntities(Class<?> entity);

	public Object getEntityById(Class<?> entity, Long id);

	public void delete(Object entity);

	public List<Object> getFindCriteriaGeneric(Class<?> entity, String whereCondition, Object[] parameters);

}
