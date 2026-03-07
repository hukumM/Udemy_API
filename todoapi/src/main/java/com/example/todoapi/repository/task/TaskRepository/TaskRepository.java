package com.example.todoapi.repository.task.TaskRepository;

import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TaskRepository {
	
	@Select("select id, title from tasks where id = #{taskId}")
	Optional<TaskRecord> select(long taskId);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("insert into tasks (title) values (#{title})")
	void insert(TaskRecord record);
	
	

}
