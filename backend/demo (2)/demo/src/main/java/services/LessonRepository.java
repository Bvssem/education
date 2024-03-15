package com.userservice.UserService.repos;

import com.userservice.UserService.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    // You can add custom queries here if needed
}
