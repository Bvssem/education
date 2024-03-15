package com.userservice.UserService.controllers;

import com.userservice.UserService.entities.Student;
import com.userservice.UserService.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/signup")
    public ResponseEntity<Student> signUpStudent(@RequestBody Student student) {
        // Validate input (e.g., check if email is unique)
        // You can add more validation logic here

        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.ok(student);
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentRepository.findAll();
        return ResponseEntity.ok(allStudents);
    }
    @PostMapping("/login")
    public ResponseEntity<String> studentLogin(@RequestParam String email, @RequestParam String password) {
        // Validate input (e.g., check if email exists)
        Student student = studentRepository.findByEmail(email);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }

        // Validate password (you can use a password encoder)
        if (!student.getPassword().equals(password)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password");
        }

        // Successful login
        return ResponseEntity.ok("Login successful");
    }

}

