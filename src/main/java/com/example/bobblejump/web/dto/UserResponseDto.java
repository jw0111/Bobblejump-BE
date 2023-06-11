package com.example.bobblejump.web.dto;

import com.example.bobblejump.domain.user.Role;
import com.example.bobblejump.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    String username;
    int character;
    int score;
    Role role;
    LocalDateTime createdAt;

    public UserResponseDto(User entity){
        this.username = entity.getUserName();
        this.character = entity.getPlayer();
        this.score = entity.getScore();
        this.role = entity.getRole();
        this.createdAt = entity.getCreatedAt();
    }
}

