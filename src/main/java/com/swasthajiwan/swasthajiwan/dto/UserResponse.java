package com.swasthajiwan.swasthajiwan.dto;

import java.time.LocalDateTime;

public class UserResponse {  // Class name fixed

    private String id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt;

    // Default constructor
    public UserResponse() {}

    // Constructor to map from entity
    public UserResponse(String id, String fullName, String email, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.createdAt = createdAt;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
