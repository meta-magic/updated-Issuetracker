/*package com.issuetracker.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.issuetracker.service.UserRegistrationService;
@Component
@Aspect
@Order
public class AspectController {
	@Autowired
	private UserRegistrationService userregistrationservice;

	@Around("execution(* com.issuetracker.controller..*.*(..))")
	public Object addMessage(ProceedingJoinPoint joinPoint) {
		
		return "HELLO";
	}

}
*/