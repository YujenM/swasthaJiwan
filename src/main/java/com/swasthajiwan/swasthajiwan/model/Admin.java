package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "id",unique = true,nullable = false,length = 50)
    private String id;

    @Column(name = "email",length = 100)
    private String email;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "password",length = 100)
    private String password;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
