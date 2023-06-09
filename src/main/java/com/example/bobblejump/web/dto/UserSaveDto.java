package com.example.bobblejump.web.dto;

import com.example.bobblejump.domain.user.Role;
import com.example.bobblejump.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserSaveDto {
    private String userName;
    private String userEmail;
    private String userPwd;
    private Role role;

    @Builder
    public User toEntity(){
        return User.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPwd(userPwd)
                .role(role)
                .build();
    }

}
