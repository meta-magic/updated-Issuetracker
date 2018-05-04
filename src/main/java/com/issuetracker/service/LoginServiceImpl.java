package com.issuetracker.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.issuetracker.dto.Logindto;
import com.issuetracker.dto.RoleDto;
import com.issuetracker.dto.UserDTO;
import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.model.Login;
import com.issuetracker.model.User;
import com.issuetracker.repository.LoginRepository;
import com.issuetracker.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginrepository;

	@Autowired
	private UserRepository userRepository;

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
	public UserDTO doLogin(Logindto logindto) throws PersistenceFailureException {
		UserDTO userDTO = null;
		if (logindto.loginId == null || logindto.password == null) {
			throw new PersistenceFailureException("Invalid Login Details");

		}
		Login login = loginrepository.findById(logindto.loginId, logindto.password);
		User user = userRepository.findByLoginId(login.getId());
		if (login != null && user != null) {
			userDTO = new UserDTO(user.getUserId(), this.tokenGeneration(login.getLoginId(), 1));
		}
		return userDTO;
	}

	// TO GENERATE TOKEN USING LOGIN ID AND ROLE
	private String tokenGeneration(String loginId, int role) {
		String tokenId = null;
		int roleId = 1;
		if (role == 1) {
			tokenId = Jwts.builder().setSubject(loginId).claim("role", "Customer").setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		} else {
			tokenId = Jwts.builder().setSubject(loginId).claim("role", "Admin").setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		}
		return tokenId;
	}

	@Override
	public Object findByLoginId(String loginId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public RoleDto doLogin(UserDTO userDTO) throws
	 * PersistenceFailureException { RoleDto roleDTO=null;
	 * if(userDTO.getUserId()!=0) { throw new
	 * PersistenceFailureException("Invalid User Details"); User
	 * user=userRepository.findByLoginId(userDTO.getUserId())); } return null; }
	 */

}
