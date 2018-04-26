/*package com.issuetracker.aspect;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.async.DeferredResult;

import com.issuetracker.dto.LoginInfoHelperbean;
import com.issuetracker.dto.ResponseBean;
import com.issuetracker.service.TokenService;

import atg.taglib.json.util.JSONObject;
import io.jsonwebtoken.ExpiredJwtException;

@Component
@Aspect
@Order(2)
@Scope(value = "request")

public class TokenAspect {
	@Autowired
	private TokenService tokenService;
	
	private LoginInfoHelperbean loginhelperbean;
	
	@Around("allOperations() && !insecureCalls()")
	public Object validateToken(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		DeferredResult<ResponseEntity<ResponseBean>> deferredResult = new DeferredResult<>(60000L);
		try {
			JSONObject jsonObject = tokenService.getTokenData((String) request.getHeader("tokenid"));
			loginhelperbean.setProperty( jsonObject.getString("loginId"), jsonObject.getString("userId"));
		} catch (ExpiredJwtException e) {
			ResponseBean responseBean = new ResponseBean(false, "", "Token Expired");
					Arrays.asList(e.getMessage());
			deferredResult.setErrorResult(new ResponseEntity<ResponseBean>(responseBean, HttpStatus.UNAUTHORIZED));
			return deferredResult;
		} catch (IllegalArgumentException e) {
			ResponseBean responseBean = new ResponseBean(false, "","Token Required");
					Arrays.asList(e.getMessage());
			deferredResult.setErrorResult(new ResponseEntity<ResponseBean>(responseBean, HttpStatus.UNAUTHORIZED));
			return deferredResult;
		} catch (Exception e) {
			ResponseBean responseBean = new ResponseBean(false,"","Token Invalid");
					Arrays.asList(e.getMessage());
			deferredResult.setErrorResult(new ResponseEntity<ResponseBean>(responseBean, HttpStatus.UNAUTHORIZED));
			return deferredResult;
		}
		return joinPoint.proceed();
	}

	@Pointcut("execution(* com.issuetracker.controller..*.*(..))")
	public void allOperations() {
	}

	@Pointcut("execution(* com.issuetracker.controller.LoginController.*.*(..))")
	public void insecureCalls() {
	}
	
	
	

}
*/