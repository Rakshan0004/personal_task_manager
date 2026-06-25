package com.personal.taskmanager.services;

import org.springframework.stereotype.Service;
import com.personal.taskmanager.dtos.UserRequestDTO;
import com.personal.taskmanager.dtos.UserResponseDTO;
import com.personal.taskmanager.models.User;
import com.personal.taskmanager.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createuser(UserRequestDTO dto){
        
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email is already registered");
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDTO.builder()
            .id(savedUser.getId())
            .name(savedUser.getName())
            .email(savedUser.getEmail())
            .build();
    }
}