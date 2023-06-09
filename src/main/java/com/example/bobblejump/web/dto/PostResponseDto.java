package com.example.bobblejump.web.dto;

import com.example.bobblejump.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long postId;
    private String title;
    private String userName;
    private LocalDateTime createdAt;

    public PostResponseDto(Post entity){
        this.postId = entity.getPostId();
        this.title = entity.getTitle();
        this.userName = entity.getUser().getUserName();
        this.createdAt = entity.getCreatedAt();
    }

}