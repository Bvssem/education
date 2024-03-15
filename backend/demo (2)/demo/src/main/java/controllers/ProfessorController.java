package com.userservice.UserService.controllers;

import com.userservice.UserService.entities.Professor;
import com.userservice.UserService.repos.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping("/signup")
    public ResponseEntity<Professor> signUpProfessor(@RequestBody Professor professor) {
        // Validate input (e.g., check if email is unique)
        // You can add more validation logic here

        Professor savedProfessor = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfessor);
    }

    @GetMapping("/{professorId}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long professorId) {
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new RuntimeException("Professor not found"));
        return ResponseEntity.ok(professor);
    }

    @GetMapping("/")
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> allProfessors = professorRepository.findAll();
        return ResponseEntity.ok(allProfessors);
    }

    @PostMapping("/login")
    public ResponseEntity<String> professorLogin(@RequestParam String email, @RequestParam String password) {
        // Validate input (e.g., check if email exists)
        Professor professor = professorRepository.findByEmail(email);
        if (professor == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor not found");
        }

        // Validate password (you can use a password encoder)
        if (!professor.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
        }

        // Successful login
        return ResponseEntity.ok("Login successful");
    }
}
