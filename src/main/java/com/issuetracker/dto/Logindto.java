package com.issuetracker.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.issuetracker.utils.CommonValidator;

public class Logindto implements CommonValidator {
	@NotNull(message = "Login id shoud not be null")
	@Size(min = 4, max = 20, message = "Login id must be between 4 and 20 characters")
	public String loginId;
	
	@NotNull(message = "password number should not be null")
	@Size(min = 5, max = 20, message = "Password number must be between 5 and 20 characters")
	public String password;

	public Logindto() {
		super();
	}

	public Logindto(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
		System.out.println("loginid = " + loginId + "  password = " + password);
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Logindto [loginId=" + loginId + ", password=" + password + "]";
	}

}
