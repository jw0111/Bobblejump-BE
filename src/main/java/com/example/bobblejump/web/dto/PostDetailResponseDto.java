package com.example.bobblejump.web.dto;

import com.example.bobblejump.domain.hearts.Hearts;
import com.example.bobblejump.domain.post.Post;
import com.example.bobblejump.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDetailResponseDto {
    private String title;
    private String content;
    private String userName;
    private int heartCnt;
    private boolean hearted;
    private LocalDateTime createdAt;

    public PostDetailResponseDto(Post post, User user){
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userName = user.getUserName();
        this.createdAt = post.getCreatedAt();
    }
}
