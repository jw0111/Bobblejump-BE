package com.example.bobblejump.web.dto;

import com.example.bobblejump.domain.user.Role;
import com.example.bobblejump.domain.user.User;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    String username;
    int character;
    int level;
    Role role;
    LocalDateTime createdAt;

    public UserResponseDto(User entity){
        this.username = entity.getUserName();
        this.character = entity.getPlayer();
        this.level = entity.getLevel();
        this.role = entity.getRole();
        this.createdAt = entity.getCreatedAt();
    }
}

