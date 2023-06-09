package com.example.bobblejump.domain.like;

import com.example.bobblejump.BaseTimeEntity;
import com.example.bobblejump.domain.post.Post;
import com.example.bobblejump.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class Like extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    Post post;

}
