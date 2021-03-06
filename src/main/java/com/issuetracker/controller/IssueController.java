package com.issuetracker.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.issuetracker.dto.IssueDTO;
import com.issuetracker.dto.ResponseBean;
import com.issuetracker.exceptions.BaseException;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Issue;
import com.issuetracker.service.IssueService;

@RestController
@RequestMapping("/issue")
public class IssueController {

	@Autowired
	private IssueService issueService;

	/*---------------Issue Find by userId---------*/
	@GetMapping
	@RequestMapping("/findByRaisedBy")
	public ResponseBean findByRaisedBy(@RequestParam("userId") Integer userId,HttpServletRequest httpServletRequest) throws PersistenceFailureException {
		httpServletRequest.getHeaderNames();
		Collection<Issue> issues = issueService.findByRaisedBy(userId);
		ResponseBean responseBean = new ResponseBean(true, "Data retrived successfully",null,issues);
		return responseBean;
	}
	/*------------Save Method of Issue-------*/

	@PostMapping("/saveIssue")
	public ResponseBean save(@RequestBody Issue issue) {
		ResponseBean responseBean = null;
		try {
			issueService.save(issue);
			responseBean = new ResponseBean(true, "Issue saved Succesfully", null,null);
		} catch (BaseException e) {
			responseBean = new ResponseBean(false,"Issue Not Saved", null, e);
			e.printStackTrace();
		}

		return responseBean;
	}

	/*--------------Assign Method of Issue-------*/
	@PostMapping("/issueAssignTo")
	public ResponseBean issueAssignTo(@RequestBody IssueDTO issuedto) {
		ResponseBean responseBean = null;
		try {
			issueService.updateAssign(issuedto);;
			responseBean = new ResponseBean(true, "Issue Assigned", null, null);
		} catch (Throwable e) {
			responseBean = new ResponseBean(false, "", null, "Issue Not Assigned");
			e.printStackTrace();
		}
		return responseBean;
	}
	
	
	
}
