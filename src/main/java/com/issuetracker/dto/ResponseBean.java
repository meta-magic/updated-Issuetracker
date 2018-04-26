package com.issuetracker.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8883721934829144347L;

	private boolean success;

	private String successMessage;

	private Object errorMessage;

	private List<String> errors;

	private Object data;

	public ResponseBean() {
		super();

	}

	public ResponseBean(boolean success, String successMessage, Object errorMessage) {
		super();
		this.success = success;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
	}

	public ResponseBean(boolean success, String successMessage, Object errorMessage, List<String> errors, Object data) {
		super();
		this.success = success;
		this.successMessage = successMessage;
		this.errorMessage = errorMessage;
		this.errors = errors;
		this.data = data;
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

	public void setErrorMessage(Object errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public Object getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ResponseBean [success=" + success + ", successMessage=" + successMessage + ", errorMessage="
				+ errorMessage + "]";
	}

}
