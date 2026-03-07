package com.example.todoapi.dto;

import java.time.LocalDateTime;

import lombok.Value;

@Value
public class SampleDto {

	String content;
	LocalDateTime timestamp;
}
