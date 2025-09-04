package com.swasthajiwan.swasthajiwan.dto;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponse {

    private String id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt;
    private String role;

    public UserResponse() {}

    public UserResponse(String id, String fullName, String email, LocalDateTime createdAt, String role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.createdAt = createdAt;
        this.role = role;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
