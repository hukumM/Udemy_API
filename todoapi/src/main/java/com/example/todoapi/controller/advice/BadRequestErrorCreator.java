package com.example.todoapi.controller.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.todoapi.model.BadRequestError;
import com.example.todoapi.model.InvalidParam;

public class BadRequestErrorCreator {

	public static BadRequestError form(MethodArgumentNotValidException ex) {
		
		var invalidParamList = createInvalidParamList(ex);
		var error = new BadRequestError();
		error.setInvalidParams(invalidParamList);
		
		return error;
	}

	private static List<InvalidParam> createInvalidParamList(MethodArgumentNotValidException ex) {
		return ex.getFieldErrors()
				.stream()
				.map(BadRequestErrorCreator::createInvalidParam)
				.collect(Collectors.toList());
	}

	private static InvalidParam createInvalidParam(FieldError fieldError) {
		var invalidParam = new InvalidParam();
		invalidParam.setName(fieldError.getField());
		invalidParam.setReason(fieldError.getDefaultMessage());
		return invalidParam;
	}

}
