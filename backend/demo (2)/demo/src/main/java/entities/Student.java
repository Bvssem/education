package com.userservice.UserService.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String familyName;
    private String studentClass;
    private int age;
    private String email;
    private String password;

    public String getPassword() {
        return password;
    }


    // Constructors, getters, setters, and other methods
    // ...
}
