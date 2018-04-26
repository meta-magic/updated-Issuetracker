package com.issuetracker.service;

import java.util.List;

import com.issuetracker.dto.IssueDTO;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Issue;

public interface IssueService {

	public void updateAssign(IssueDTO issuedto) throws PersistenceFailureException;
	public Issue save(Issue issue) throws PersistenceFailureException ;
	
	public List<Issue> findByRaisedBy(Integer userId) throws PersistenceFailureException;
}
