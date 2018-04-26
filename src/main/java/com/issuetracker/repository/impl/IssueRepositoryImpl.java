package com.issuetracker.repository.impl;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import org.springframework.stereotype.Repository;

import com.issuetracker.PMFConfig;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Issue;
import com.issuetracker.repository.IssueRrepository;
import com.issuetracker.utils.ExceptionID;

@Repository
public class IssueRepositoryImpl implements IssueRrepository {

	/*--------------Find Issue by User Id------------*/
	@SuppressWarnings("unchecked")
	@Override
	public List<Issue> findByRaisedBy(Integer userId) {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Issue.class);
		query.setFilter("userId==:userId");
		List<Issue> issues = (List<Issue>) query.executeWithArray(new Object[] { userId });
		pm.close();
		return issues;
	}
/*-----------------Implementation logic of Save Method-------*/
	@Override
	public Issue save(Issue issue) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			issue = pm.makePersistent(issue);
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
/*----------------Implementation logic For Issue Id------------*/
	@Override
	public Issue findByIssueId(String issueId) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Query query = pm.newQuery(Issue.class);
		query.setFilter("issueId == :issueId");
		query.setUnique(true);
		Issue issue = (Issue) pm.detachCopy(query.execute(issueId)); 
		System.out.println("ISSUE FROM QUERY*******"+issue);
		pm.close();
		return issue;
	}
	/*----------------Implementation logic For Updating Issue raised ------------*/

	@Override
	public void update(Issue issue) throws PersistenceFailureException {
		PersistenceManager pm = PMFConfig.getPersistenceManagerFactory().getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(issue);
			System.out.println("INUPDATE CALL"+pm.makePersistent(issue));
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
		
}