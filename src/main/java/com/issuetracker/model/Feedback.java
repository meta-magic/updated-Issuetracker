package com.issuetracker.model;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class Feedback {

	private String feedbackId;
	@PrimaryKey
	private String custId;
	
	private String overallExp;
	@Persistent(name = "ISSUE_REF_ID")
	@ForeignKey
	private String issueRefId;
	
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getOverallExp() {
		return overallExp;
	}
	public void setOverallExp(String overallExp) {
		this.overallExp = overallExp;
	}
	public String getCustSatifaction() {
		return custSatifaction;
	}
	public void setCustSatifaction(String custSatifaction) {
		this.custSatifaction = custSatifaction;
	}
	public String getCustServiceFuture() {
		return custServiceFuture;
	}
	public void setCustServiceFuture(String custServiceFuture) {
		this.custServiceFuture = custServiceFuture;
	}
	public String getRating() {
		return Rating;
	}
	public void setRating(String rating) {
		Rating = rating;
	}
	public String getIssueRefId() {
		return issueRefId;
	}
	public void setIssueRefId(String issueRefId) {
		this.issueRefId = issueRefId;
	}
	private String custSatifaction;
	
	private String custServiceFuture;
	
	private String Rating;
	
}
