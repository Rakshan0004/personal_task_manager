package com.personal.taskmanager.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.personal.taskmanager.dtos.TaskRequestDTO;
import com.personal.taskmanager.dtos.TaskResponseDTO;
import com.personal.taskmanager.models.Task;
import com.personal.taskmanager.models.User;
import com.personal.taskmanager.repository.TaskRepository;
import com.personal.taskmanager.repository.UserRepository;
import com.personal.taskmanager.exceptions.ResourceNotFoundException;


@Service
@RequiredArgsConstructor
public class TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskResponseDTO createTask(TaskRequestDTO task){

        User user = userRepository.findById(task.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + task.getUserId()));


        Task newTask = Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .status(task.getStatus())
                .user(user)
                .build();


        Task savedTask = taskRepository.save(newTask);
        return TaskResponseDTO.builder()
                    .id(savedTask.getId())
                    .title(savedTask.getTitle())
                    .description(savedTask.getDescription())
                    .dueDate(savedTask.getDueDate())
                    .status(savedTask.getStatus())
                    .userId(savedTask.getUser().getId())
                    .createdAt(savedTask.getCreatedAt())
                    .updatedAt(savedTask.getUpdatedAt())
                    .build();            
    }
}