package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "validate")
public class Validate {
    @Id
    @Column(name = "userId",nullable = false)
    private String userId;

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "isValidate")
    private Boolean isValidate;

    @Column(name = "reason",columnDefinition = "text")
    private String reason;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


//    getter and setter
    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }
    public Boolean getIsValidate(){
        return isValidate;
    }
    public void setIsValidate(Boolean isValidate){
        this.isValidate=isValidate;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
