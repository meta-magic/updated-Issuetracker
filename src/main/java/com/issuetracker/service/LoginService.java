package com.issuetracker.service;

import com.issuetracker.dto.Logindto;
import com.issuetracker.dto.RoleDto;
import com.issuetracker.dto.UserDTO;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;

public interface LoginService {

	public Login save(Login login);

	public UserDTO doLogin(Logindto logindto) throws PersistenceFailureException;
	
	//public RoleDto doLogin(UserDTO userDTO)throws PersistenceFailureException;


	public Object findByLoginId(String loginId, String password);


}
