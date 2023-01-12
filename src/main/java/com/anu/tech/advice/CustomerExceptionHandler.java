package com.anu.tech.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ProblemDetail onExceptionOccure(RuntimeException exception)
	
	{
		
		var pd=ProblemDetail.forStatusAndDetail(HttpStatus.valueOf(400), exception.getMessage());
		return pd;
	}
	
	

}
