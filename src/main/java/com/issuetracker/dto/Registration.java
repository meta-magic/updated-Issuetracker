package com.issuetracker.dto;

public class Registration {

	private String firstName;

	private String lastName;

	private String loginId;

	private String password;

	private int roleId;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(String firstName, String lastName, String loginId, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
	}

	public Registration(String firstName, String lastName, String loginId, String password, int roleId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
		this.roleId = roleId;
	}

	public String getFirstName() {
		System.out.println("in Regiater");
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
