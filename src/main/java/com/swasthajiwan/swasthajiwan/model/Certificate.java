package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "certificate")
public class Certificate {
    @Id
    @Column(name = "id",nullable = false,unique = true)
    private int id;

    @Column (name = "userId",nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false, updatable = false)
    private User user;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "path",length = 500)
    private String path;

    @Column(name = "startDate")
    private LocalDateTime startDate;

    @Column(name = "endDate")
    private LocalDateTime endDate;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

//    getter and setter

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
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
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path=path;
    }
    public LocalDateTime getStartDate(){
        return startDate;
    }
    public void setStartDate(LocalDateTime startDate){
        this.startDate=startDate;
    }
    public LocalDateTime getEndDate(){
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate){
        this.endDate=endDate;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}
