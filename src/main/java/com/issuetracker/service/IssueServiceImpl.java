package com.issuetracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issuetracker.dto.IssueDTO;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Issue;
import com.issuetracker.repository.IssueRrepository;

@Service
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueRrepository issuerepository;
/*-----------Save Method with Current date-------------*/
	@Override
	public Issue save(Issue issue) throws PersistenceFailureException {
	    issue.setDate(new Date(System.currentTimeMillis()));
		Issue saveIssue = issuerepository.save(issue);
		return saveIssue;
	}
/*-----------Find By UserId Method--------------------*/
	@Override
	public List<Issue> findByRaisedBy(Integer userId) throws PersistenceFailureException {
		return issuerepository.findByRaisedBy(userId);
	}
/*-----------Update Method for Issue To be Assigned------*/
	@Override
	public void updateAssign(IssueDTO issuedto) throws PersistenceFailureException {
		Issue issue=issuerepository.findByIssueId(issuedto.getIssueId());
		System.out.println("****ISSUE"+issue.getIssueId());
		issue.setIssueId(issue.getIssueId());
		issue.setAssignTo(issuedto.getAssignTo());
		issuerepository.update(issue);
		System.out.println("AFTER UPDATE ISSUE: "+issue.getIssueId());
	}

}
/*
 * @Override public List<Issue> findRaisedby(Integer raisedBy) throws
 * PersistenceFailureException { Collection<Issue> issues =
 * issuerepository.findByRaisedBy(raisedBy); return null;
 * 
 * }
 */

/*
 * @Override public List<Issue> findByRefId(String issueRefId) throws
 * PersistenceFailureException { List<Issue> issues =
 * issuerepository.findByIssueRefNo(issueRefId); return issues; }
 */
