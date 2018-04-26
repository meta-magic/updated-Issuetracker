package com.issuetracker.model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.issuetracker.utils.CommonValidator;

@PersistenceCapable(detachable = "true", table = "Login")
public class Login implements Serializable, CommonValidator {

	private static final long serialVersionUID = 1L;

	// Data Members
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private Long id;

	@Persistent(name = "LOGINID")
	@NotNull(message = "Login id shoud not be null")
	@Size(min = 4, max = 20, message = "Login id must be between 4 and 20 characters")
	@Unique
	private String loginId;

	@Persistent(name = "PASSWORD")
	@NotNull(message = "password number should not be null")
	@Size(min = 5, max = 20, message = "Password number must be between 5 and 20 characters")
	private String password;

	public Login() {
		super();
	}

	public Login(String loginId, String password) {
		super();

		this.loginId = loginId;
		this.password = password;
	}

	// Getter Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}