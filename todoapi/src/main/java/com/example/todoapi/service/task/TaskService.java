package com.example.todoapi.service.task;

import org.springframework.stereotype.Service;

import com.example.todoapi.repository.task.TaskRepository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	private final TaskRepository taskRepository;

	public TaskEntity find(long taskId) {
		return taskRepository.select(taskId)
				.map(record -> new TaskEntity(record.getId(), record.getTitle()))
				.orElseThrow(() -> new TaskEntityNotFoundException(taskId));
	}

}
