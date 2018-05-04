package com.issuetracker.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8883721934829144347L;

	private boolean success;

	private String message;

	private List<String> errors;

	private Object data;

	public ResponseBean(boolean success, String message, List<String> errors, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.errors = errors;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	

}
