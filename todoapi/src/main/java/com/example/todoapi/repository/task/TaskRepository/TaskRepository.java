package com.example.todoapi.repository.task.TaskRepository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {
	
	@Select("select id, title from tasks where id = #{taskId}")
	Optional<TaskRecord> select(long taskId);

}
