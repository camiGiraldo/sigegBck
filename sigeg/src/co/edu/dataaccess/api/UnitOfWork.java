package co.edu.dataaccess.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UnitOfWork {

	private Session session;
	private Transaction transaction;

	public UnitOfWork(SessionFactory sessionFactory) {
		this.session = sessionFactory.getCurrentSession();
	}

	public void beginTransaction() {
		if (this.transaction == null) {
			this.transaction = this.session.getTransaction();
		}
		this.transaction.begin();
	}

	public void commit() {
		if (this.transaction != null) {
			this.transaction.commit();
		}
	}

	public void rollback() {
		if (this.transaction != null) {
			this.transaction.rollback();
		}
	}

}