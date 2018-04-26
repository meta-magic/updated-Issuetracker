package com.issuetracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issuetracker.dto.Logindto;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;
import com.issuetracker.repository.LoginRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginrepository;
	

	@Override
	public Login save(Login login) {
		try {
			loginrepository.save(login);
		} catch (PersistenceFailureException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean doLogin(Logindto logindto) throws PersistenceFailureException {
		boolean flag = false;
		if (logindto.loginId == null || logindto.password == null) {
			throw new PersistenceFailureException("Invalid Login Details");
		}
		Login login = loginrepository.findById(logindto.loginId, logindto.password);
		if (login != null) {
			flag = true;
       
		}
		
		return flag;
	}

	@Override
	public Object findByLoginId(String loginId, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
