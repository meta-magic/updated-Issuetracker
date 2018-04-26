/**
 * 
 */
package com.issuetracker.repository.impl;

import javax.jdo.PersistenceManager;

import javax.jdo.Transaction;


import org.springframework.stereotype.Repository;

import com.issuetracker.PMFConfig;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;
import com.issuetracker.model.User;
import com.issuetracker.repository.UserRepository;
import com.issuetracker.utils.ExceptionID;

@Repository
public class UserRepositoryImpl  implements UserRepository{
	
	@Override
	public  User findbyloginId(String login_id) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			login_id = pm.makePersistent(login_id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
			throw new PersistenceFailureException(ExceptionID.ERROR_RETRIEVE, e);
		} finally {
			pm.close();
		}
		return null;
		
	}

	@Override
	public  User save(User user) throws PersistenceFailureException {
		PersistenceManager pm =PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
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
