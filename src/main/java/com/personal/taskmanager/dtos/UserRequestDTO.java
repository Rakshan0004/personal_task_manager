package com.personal.taskmanager.dtos;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @NotEmpty(message = "Name is required")
    private String name;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
}
