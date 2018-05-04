package com.issuetracker.repository;

import java.util.List;

import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Issue;

public interface IssueRrepository {

	public List<Issue> findByRaisedBy(Integer userId);

	public Issue save(Issue issue) throws PersistenceFailureException;

	public void update(Issue issue) throws PersistenceFailureException;
	// public Issue findByIssueId(IssueDTO issuedto)throws
	// PersistenceFailureException;

	public Issue findByIssueId(String issueId) throws PersistenceFailureException;
	
	
	
	

}
