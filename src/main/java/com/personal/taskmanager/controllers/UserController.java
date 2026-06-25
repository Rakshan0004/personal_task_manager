package com.personal.taskmanager.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.personal.taskmanager.models.User;
import com.personal.taskmanager.dtos.UserRequestDTO;
import com.personal.taskmanager.dtos.UserResponseDTO;
import com.personal.taskmanager.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public UserResponseDTO createUser(@Valid @RequestBody UserRequestDTO dto){
        return userService.createuser(dto);
    }

}