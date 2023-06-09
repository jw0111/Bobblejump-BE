package com.example.bobblejump.domain.post;

import com.example.bobblejump.BaseTimeEntity;
import com.example.bobblejump.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    private String title;

    private String content;

    @Builder
    public Post(User user, String title, String content){
        this.user = user;
        this.title = title;
        this.content = content;
    }
}
