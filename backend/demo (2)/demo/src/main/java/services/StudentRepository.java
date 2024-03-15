package com.userservice.UserService.repos;

import com.userservice.UserService.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    com.userservice.UserService.entities.Student findByEmail(String email);
    // You can add custom queries here if needed
}
