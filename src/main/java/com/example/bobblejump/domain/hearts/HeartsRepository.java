package com.example.bobblejump.domain.hearts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartsRepository extends JpaRepository<Hearts, Long> {
}
