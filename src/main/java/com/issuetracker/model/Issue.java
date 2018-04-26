package com.issuetracker.model;

import java.io.Serializable;
import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.NotNull;

@PersistenceCapable(detachable = "true", table = "Issue")
public class Issue implements Serializable {

	private static final long serialVersionUID = 1L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT, name = "ISSUEID")
	private String issueId;

	@Persistent(name = "ISSUE_REF_ID")
	@NotNull
	private String issueRefId;

	@Persistent(name = "ISSUEDESC")
	@NotNull
	private String issueDesc;

	@Persistent(name = "PRIORITY")
	@NotNull
	private String priority;

	@Persistent(name = "SEVERITY")
	@NotNull
	private String severity;

	@ForeignKey(table = "user", name = "userId")
	@Persistent(name = "USERID")
	@NotNull
	private Integer userId;

	@Persistent(name = "DATE")
	@NotNull
	private Date date;

	@Persistent(name = "STATUS")
	@NotNull
	private String status;

	@Persistent(name = "ISSUENAME")
	@NotNull
	private String issueName;
	
	@Persistent(name="ASSIGNTO")
	
	private String assignTo;

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getIssueRefId() {
		return issueRefId;
	}

	public void setIssueRefId(String issueRefId) {
		this.issueRefId = issueRefId;
	}

	public String getIssueDesc() {
		return issueDesc;
	}

	public void setIssueDesc(String issueDesc) {
		this.issueDesc = issueDesc;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Issue(String issueRefId, String issueDesc, String priority, String severity, Integer userId, Date date,
			String status, String issueName,String assignTo) {
		super();
		this.issueRefId = issueRefId;
		this.issueDesc = issueDesc;
		this.priority = priority;
		this.severity = severity;
		this.userId = userId;
		this.date = date;
		this.status = status;
		this.issueName = issueName;
		this.assignTo=assignTo;
	}

	public Issue(String issueRefId, String assignto, Integer userId) {
	this.issueRefId=issueRefId;
	this.assignTo=assignTo;
	this.userId=userId;
	}

	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueRefId=" + issueRefId + ", issueDesc=" + issueDesc + ", priority="
				+ priority + ", severity=" + severity + ", userId=" + userId + ", date=" + date + ", status=" + status
				+ ", issueName=" + issueName + ", assignTo=" + assignTo + "]";
	}

	
}
