package com.example.bobblejump.domain.hearts;

import com.example.bobblejump.BaseTimeEntity;
import com.example.bobblejump.domain.post.Post;
import com.example.bobblejump.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@NoArgsConstructor
@DynamicInsert
public class Hearts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long HeartsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    Post post;

    @Builder
    public Hearts(User user, Post post){
        this.user = user;
        this.post = post;
    }
}
