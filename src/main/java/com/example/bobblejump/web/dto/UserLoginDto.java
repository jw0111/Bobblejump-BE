package com.example.bobblejump.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
public class UserLoginDto {
    private String email;
    private String password;

    @Builder
    public UserLoginDto(String email, String password){
        this.email = email;
        this.password = password;
    }
}
