package com.issuetracker.model;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
@PersistenceCapable(detachable="true",table="Role")
public class Role implements Serializable {
	//Data Members
	private static final long serialVersionUID = 1L;

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private int roleId;
	@Persistent(name="Role")
	private String role;
	@Persistent(name="description")
	private String description;
	//Constructor
	public Role(int roleId,String role,String description) {
		
	}
	//Getter Setter for Data Members
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	




}
