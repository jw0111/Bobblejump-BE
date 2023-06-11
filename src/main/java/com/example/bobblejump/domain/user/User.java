package com.example.bobblejump.domain.user;

import com.example.bobblejump.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @ToString
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;

    @Getter
    private String userPwd;

    private String userEmail;

    private int score;

    private int player;

    @Enumerated(EnumType.STRING)
    @Setter
    private Role role;

    @Builder
    public User(String userName, String userPwd, String userEmail, Role role){
        this.userName = userName;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.score = 0;
        this.player = 0;
        this.role = role;
    }
}
