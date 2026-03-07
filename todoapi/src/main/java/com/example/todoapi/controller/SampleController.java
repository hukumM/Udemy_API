package com.example.todoapi.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.dto.SampleDto;
import com.example.todoapi.entity.SampleEntity;
import com.example.todoapi.service.SampleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/samples")
@RequiredArgsConstructor
public class SampleController {
	
	private final SampleService service;
	
	@GetMapping
	public SampleDto index() {
		SampleEntity entity = service.find();
		return new SampleDto(entity.getContent(), LocalDateTime.now());
	}

}
