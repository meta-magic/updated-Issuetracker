package com.issuetracker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issuetracker.dto.Logindto;
import com.issuetracker.dto.ResponseBean;
import com.issuetracker.exceptions.PersistenceFailureException;
//import com.issuetracker.exceptions.PersistenceFailureException;
import com.issuetracker.repository.LoginRepository;
import com.issuetracker.service.LoginService;
import com.issuetracker.utils.DataValidator;

@RestController

@RequestMapping(value = "/LoginController")
public class LoginController {

	@Autowired
	private LoginRepository loginRepo;
	@Autowired
	private LoginService loginservice;

	

	@PostMapping
	@RequestMapping("/LoginDTO")
	public ResponseBean doLogin(@RequestBody Logindto logindto,HttpServletRequest httpServletRequest) throws PersistenceFailureException {
		System.out.println("In doLogin method of Login Controller");
		ResponseBean responseBean = null;
		httpServletRequest.getHeaderNames();
		/** validating incoming data */
		List<String> result = DataValidator.validate(logindto);
		if (!result.isEmpty()) {
			responseBean = new ResponseBean(false, "Data constraint failed ", result);
		}

		Boolean isLogin = loginservice.doLogin(logindto);
		if (isLogin) {
			responseBean = new ResponseBean(true, "User Login Successfully.", null);
		} else {
			responseBean = new ResponseBean(false, "User Login failed.", null);
		}
		return responseBean;
	}

	@PostMapping("/findByLoginId")
	public void findByLoginId(@RequestBody Logindto logindto) throws PersistenceFailureException {
		System.out.println("In FindByLoginID of Login Controller");
		loginRepo.findById(logindto.getLoginId(), logindto.getPassword());
	}

	

}
