package com.personal.taskmanager.dtos;

import com.personal.taskmanager.models.Status;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDTO {
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;
    private Long userId;
}