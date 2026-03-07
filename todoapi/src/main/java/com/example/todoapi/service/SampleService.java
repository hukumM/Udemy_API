package com.example.todoapi.service;

import org.springframework.stereotype.Service;

import com.example.todoapi.entity.SampleEntity;
import com.example.todoapi.repository.SampleRecord;
import com.example.todoapi.repository.SampleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {
	
	private final SampleRepository repository;
	
	public SampleEntity find() {
		SampleRecord record = repository.select();
		return new SampleEntity(record.getContent());
	}
}
