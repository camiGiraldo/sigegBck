package co.edu.delegate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.dataaccess.api.GenericLogic;
import co.edu.exceptions.ZMessManager;

@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {

	private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);

	@Autowired
	private GenericLogic genericLogic;

	public void saveGeneric(Object entity) {
		try {
			genericLogic.save(entity);
		} catch (Exception e) {
			log.error(String.format("Save Generic Failed -> %s", e.getMessage()));
			genericLogic.rollBack();
			throw new ZMessManager.TransactionException(e.getMessage());
		}
	}

	public void updateGeneric(Object entity) {
		try {
			genericLogic.update(entity);
		} catch (Exception e) {
			log.error(String.format("Update Generic Failed -> %s", e.getMessage()));
			genericLogic.rollBack();
			throw new ZMessManager.TransactionException(e.getMessage());
		}
	}

	public List<Object> getAllEntities(Class<?> entity) {
		try {
			return genericLogic.getAllEntities(entity);
		} catch (Exception e) {
			log.error(String.format("get All Generic Failed -> %s", e.getMessage()));
			genericLogic.rollBack();
			throw new ZMessManager.TransactionException(e.getMessage());
		}

	}

	public Object getEntityById(Class<?> entity, Long id) {
		try {
			return genericLogic.getEntityById(entity, id);
		} catch (Exception e) {
			log.error(String.format("Get Entity By Id Failed -> %s", e.getMessage()));
			genericLogic.rollBack();
			throw new ZMessManager.TransactionException(e.getMessage());
		}
	}

	public void delete(Object entity) {
		try {
			genericLogic.delete(entity);
		} catch (Exception e) {
			log.error(String.format("Delete Generic Failed -> %s", e.getMessage()));
			genericLogic.rollBack();
			throw new ZMessManager.TransactionException(e.getMessage());
		}
	}

	public List<Object> getFindCriteriaGeneric(Class<?> entity, String whereCondition, Object[] parameters) {
		try {
			return genericLogic.getFindCriteriaGeneric(entity, whereCondition, parameters);
		} catch (Exception e) {
			log.error(String.format("Find Criteria Failed -> %s", e.getMessage()));
			genericLogic.rollBack();
			throw new ZMessManager.TransactionException(e.getMessage());
		}
	}

}
