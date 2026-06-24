package com.personal.taskmanager.dtos;

import lombok.Data;
import java.time.LocalDate;
import com.personal.taskmanager.models.Status;

@Data
public class TaskRequestDTO {
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;
    private Long userId;
}