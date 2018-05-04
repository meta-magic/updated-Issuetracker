package com.issuetracker.repository.impl;

import java.util.Collection;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Repository;

import com.issuetracker.PMFConfig;
import com.issuetracker.dto.RoleDto;
import com.issuetracker.dto.UserDTO;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;
import com.issuetracker.repository.LoginRepository;
import com.issuetracker.utils.ExceptionID;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

	// Implementation of Login Repository Methods

	@Override
	public Login findByLoginId(String loginId) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Login login = null;

		try {
			Query query = (pm.newQuery(Login.class));
			query.setFilter("this.loginId==:loginId");

			@SuppressWarnings("unchecked")
			Collection<Login> logins = (Collection<Login>) query.execute(loginId);
			if (logins.isEmpty()) {
				throw new PersistenceFailureException(ExceptionID.ERROR_RETRIEVE);
			} else {
				login = pm.detachCopy(logins.iterator().next());
			}
		} catch (Throwable e) {
			if (e instanceof PersistenceFailureException) {
				throw e;
			} else {
				e.printStackTrace();
				throw new PersistenceFailureException(e.getMessage(), e);
			}
		} finally {
			pm.close();
		}
		return login;

	}

	@Override
	public Login save(Login login) throws PersistenceFailureException {
		System.out.println("in Register Repo save login Impl");
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			login = pm.makePersistent(login);
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
	public Login findById(String loginId, String password) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Login login = null;
		try {
			Query query = (pm.newQuery(Login.class));
			query.setFilter("this.loginId==:loginId && this.password==:password");

			@SuppressWarnings("unchecked")
			Collection<Login> logins = (Collection<Login>) query.execute(loginId, password);
			if (!logins.isEmpty()) {
				login = pm.detachCopy(logins.iterator().next());
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new PersistenceFailureException(e.getMessage(), e);
		} finally {
			pm.close();
		}
		return login;
	}

	@Override
	public RoleDto doLogin(UserDTO userDTO) throws PersistenceFailureException {
		
		return null;
	}

}