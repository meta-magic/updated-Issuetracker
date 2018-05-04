package com.issuetracker.repository;

import org.springframework.stereotype.Repository;

import com.issuetracker.dto.RoleDto;
import com.issuetracker.dto.UserDTO;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;

@Repository("LoginRepository")
public interface LoginRepository {
	// Find Login by loginId
	public Login save(Login login) throws PersistenceFailureException;

	public Login findById(String loginId, String password) throws PersistenceFailureException;

	public Login findByLoginId(String loginId) throws PersistenceFailureException;
	
	public RoleDto doLogin(UserDTO userDTO)throws PersistenceFailureException;

}
