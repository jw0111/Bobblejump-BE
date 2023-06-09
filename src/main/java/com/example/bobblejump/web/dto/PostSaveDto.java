package com.example.bobblejump.web.dto;

import com.example.bobblejump.domain.post.Post;
import com.example.bobblejump.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveDto {
    private String title;
    private String content;
    private User user;

    @Builder
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
