package com.educandoweb.course.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

// Interceptar as excessões para que o objeto possa executar o tratamento
@ControllerAdvice
public class ResourceExceptionHandler {
	
	// Detecta qualquer tipo de excessão dessa classe e irá fazer o tratamento dentro do método
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request ){
		String error = "Resource not Found";
		HttpStatus status = HttpStatus.NOT_FOUND; //  404
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
}
