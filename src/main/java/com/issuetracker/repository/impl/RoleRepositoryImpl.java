package com.issuetracker.repository.impl;

import javax.jdo.PersistenceManager;

import javax.jdo.Transaction;

import org.springframework.stereotype.Repository;

import com.issuetracker.PMFConfig;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Role;
import com.issuetracker.repository.RoleRepository;
import com.issuetracker.utils.ExceptionID;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	@Override
	public Role findbyroleId(Long roleId) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		;
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			roleId = pm.makePersistent(roleId);
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
	public Role save(Long roleId) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		;
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			roleId = pm.makePersistent(roleId);
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
	public void update(Long roleId) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(roleId);
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
	public void delete(Long roleId) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.deletePersistent(pm.getObjectById(Role.class, roleId));
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
