package com.userservice.UserService.repos;

import com.userservice.UserService.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByEmail(String email);
    // You can add custom queries here if needed
}
