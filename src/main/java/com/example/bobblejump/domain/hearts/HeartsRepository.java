package com.example.bobblejump.domain.hearts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartsRepository extends JpaRepository<Hearts, Long> {
    Boolean existsByPost_PostIdAndUser_UserId(Long postId, Long userId);
    int countByPost_PostId(Long postId);
}
