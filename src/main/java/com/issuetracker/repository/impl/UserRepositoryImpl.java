/**
 * 
 */
package com.issuetracker.repository.impl;

import java.util.Collection;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Repository;

import com.issuetracker.PMFConfig;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;
import com.issuetracker.model.User;
import com.issuetracker.repository.UserRepository;
import com.issuetracker.utils.ExceptionID;

@Repository
public class UserRepositoryImpl implements UserRepository {

	/*
	 * @Override public User findByLoginId(Long id) throws
	 * PersistenceFailureException { User user = null; PersistenceManager pm =
	 * PMFConfig.getPersistenceManagerFactory().getPersistenceManager(); try { Query
	 * query = pm.newQuery(User.class); query.setFilter("this.id == :id");
	 * 
	 * 
	 * user = (User) pm.detachCopy(query.execute(id));//this line contains error
	 * 
	 * return user; } catch (Throwable e) { e.printStackTrace(); } finally {
	 * pm.close(); } return user; }
	 */
	@Override
	public User findByLoginId(int id) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		User user = null;
		try {
			Query query = (pm.newQuery(User.class));
			query.setFilter("this.id==:id");

			@SuppressWarnings("unchecked")
			Collection<User> users = (Collection<User>) query.execute(id);
			if (!users.isEmpty()) {
				user = pm.detachCopy(users.iterator().next());
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new PersistenceFailureException(e.getMessage(), e);
		} finally {
			pm.close();
		}
		return user;
	}

	@Override
	public User save(User user) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			user = pm.makePersistent(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PersistenceFailureException(ExceptionID.ERROR_SAVE, e);
		} finally {
			pm.close();
		}
		return null;
	}

	@Override
	public void update(String login_id) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(login_id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PersistenceFailureException(ExceptionID.ERROR_UPDATE, e);
		} finally {
			pm.close();
		}

	}

	@Override
	public void delete(String login_id) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.deletePersistent(pm.getObjectById(Login.class, login_id));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PersistenceFailureException(ExceptionID.ERROR_DELETE, e);
		} finally {
			pm.close();
		}
	}

}
