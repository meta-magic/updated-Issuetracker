package com.issuetracker.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issuetracker.dto.Registration;
import com.issuetracker.dto.ResponseBean;
import com.issuetracker.exceptions.BaseException;
import com.issuetracker.service.UserRegistrationService;

@RestController

@RequestMapping(value = "/register")
public class RegisterController {

	@Autowired
	private UserRegistrationService userregisterservice;

	@PostMapping("/save")
	public ResponseBean save(@RequestBody Registration registration) {
		ResponseBean responseBean = null;
		try {
			userregisterservice.save(registration);
			responseBean = new ResponseBean(true, "USER REGISTERED SUCESSFULLY.", null,null);
		} catch (BaseException e) {
			responseBean = new ResponseBean(false, null, null, "USER NOT REGISTERED");
			e.printStackTrace();
		}

		return responseBean;
	}

}
