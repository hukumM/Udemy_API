package com.example.todoapi.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.todoapi.model.ResourceNotFound;
import com.example.todoapi.service.task.TaskEntityNotFoundException;

@RestControllerAdvice
public class CustomExcepotionHandler {
	
	@ExceptionHandler(TaskEntityNotFoundException.class)
	public ResponseEntity<ResourceNotFound> handleTaskEntityNotFoundExceptino(TaskEntityNotFoundException e){
		var error = new ResourceNotFound();
		error.setDetail(e.getMessage());
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(error);
	}
}
