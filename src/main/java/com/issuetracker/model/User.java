package com.issuetracker.model;

import java.io.Serializable;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.issuetracker.utils.CommonValidator;

@PersistenceCapable(detachable = "true", table = "User")
public class User implements Serializable, CommonValidator {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int userId;

	@Persistent(name = "FIRSTNAME")
	@NotNull(message = "FirstName should not be null")
	@Size(min = 4, max = 15, message = "FirstName should not be empty")

	private String firstName;

	@Persistent(name = "LASTNAME")
	@NotNull(message = "LastName should not be null")
	@Size(min = 4, max = 15, message = "LastName should not be empty")

	private String lastName;

	@Persistent
	@ForeignKey(table = "Login", name = "id")
	@NotNull(message = "ID should not be null")

	private int id;
	@Persistent
	@ForeignKey(table = "Role", name = "roleId")
	@NotNull(message = "Role Id should not be null")
	private int roleId;

	public User() {
		super();
	}

	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(String firstName, String lastName, int id, int roleId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.roleId = roleId;
	}

	public int getUserId() {
		System.out.println("in User Model");
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", id=" + id
				+ ", roleId=" + roleId + "]";
	}
}
