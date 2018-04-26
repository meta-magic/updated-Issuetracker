package com.issuetracker.service;

import com.issuetracker.dto.Logindto;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;

public interface LoginService {

	public Login save(Login login);

	public boolean doLogin(Logindto logindto) throws PersistenceFailureException;

	public Object findByLoginId(String loginId, String password);

}
