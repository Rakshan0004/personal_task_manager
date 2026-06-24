package com.personal.taskmanager.dtos;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.personal.taskmanager.models.Status;

@Data
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
}
