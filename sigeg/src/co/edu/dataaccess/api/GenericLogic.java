package co.edu.dataaccess.api;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Scope("singleton")
@Service("GenericLogic")
public class GenericLogic {

	private SessionFactory sessionFactory;
	private UnitOfWork unitOfWork;

	public GenericLogic() {
		super();
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public Session getSession() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}
		return sessionFactory.getCurrentSession();
	}

	public CriteriaBuilder getCriteriaBuilder() {
		return getSession().getCriteriaBuilder();
	}

	public void beginTransaction() {
		unitOfWork = new UnitOfWork(sessionFactory);
		unitOfWork.beginTransaction();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Object> getAllEntities(Class<?> entity) {
		List<Object> list;
		beginTransaction();
		CriteriaQuery<?> criteria = getCriteriaBuilder().createQuery(entity);
		criteria.from(entity);
		list = (List<Object>) getSession().createQuery(criteria).getResultList();
		commit();
		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void save(Object entity) {
		beginTransaction();
		getSession().save(entity);
		commit();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(Object entity) {
		beginTransaction();
		getSession().update(entity);
		commit();
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(Object entity) {
		beginTransaction();
		getSession().delete(entity);
		commit();
	}

	@Transactional(readOnly = true)
	public Object getEntityById(Class<?> entity, Long id) {
		beginTransaction();
		Object object = getSession().get(entity, id);
		commit();
		return object;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Object> getFindCriteriaGeneric(Class<?> entity, String whereCondition, Object[] parameters) {
		beginTransaction();
		final String statement = new StringBuilder("select model from ")
				.append(entity.getSimpleName())
				.append(" model where ")
				.append(whereCondition).toString();
		TypedQuery<?> query = getSession().createQuery(statement);
		for (int i = 0; i < parameters.length; i++) {
			query.setParameter(i + 1, parameters[i]);
		}

		List<Object> list = (List<Object>) query.getResultList();
		commit();
		return list;
	}

	public void commit() {
		unitOfWork.commit();
		unitOfWork = null;
	}

	public void rollBack() {
		unitOfWork.rollback();
		unitOfWork = null;
	}

}
