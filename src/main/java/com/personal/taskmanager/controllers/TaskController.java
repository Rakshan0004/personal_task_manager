package com.personal.taskmanager.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.personal.taskmanager.dtos.TaskRequestDTO;
import com.personal.taskmanager.dtos.TaskResponseDTO;
import com.personal.taskmanager.services.TaskService;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController{

    private final TaskService taskService;

    @PostMapping("/createTask")
    public ResponseEntity<TaskResponseDTO> addTask(@Valid @RequestBody TaskRequestDTO task){

        TaskResponseDTO response =  taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}