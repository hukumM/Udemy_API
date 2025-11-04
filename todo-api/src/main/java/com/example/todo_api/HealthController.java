package com.example.todo_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.controller.HealthApi;

@RestController
public class HealthController implements HealthApi{

    @Override
    public ResponseEntity<Void> healthGet(){
        return ResponseEntity.ok().build();
        }
    
}
