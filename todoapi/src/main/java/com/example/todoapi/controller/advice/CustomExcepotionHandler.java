package com.example.todoapi.controller.advice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.todoapi.model.ResourceNotFound;
import com.example.todoapi.service.task.TaskEntityNotFoundException;

@RestControllerAdvice
public class CustomExcepotionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(TaskEntityNotFoundException.class)
	public ResponseEntity<ResourceNotFound> handleTaskEntityNotFoundExceptino(TaskEntityNotFoundException e){
		var error = new ResourceNotFound();
		error.setDetail(e.getMessage());
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatusCode status,
			WebRequest request
			) {
		
		var error = BadRequestErrorCreator.form(ex);

		return ResponseEntity.badRequest()
				.body(error);
	}

	
	
}
