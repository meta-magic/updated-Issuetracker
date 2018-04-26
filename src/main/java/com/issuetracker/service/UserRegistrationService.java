package com.issuetracker.service;

import com.issuetracker.dto.Registration;
import com.issuetracker.exceptions.BaseException;

public interface UserRegistrationService {
	public void save(Registration registration) throws BaseException;

}
