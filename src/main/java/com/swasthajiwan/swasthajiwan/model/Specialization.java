package com.swasthajiwan.swasthajiwan.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @Column(name = "id",nullable = false,unique = true,length = 50)
    private String id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "description",columnDefinition = "Text")
    private String description;

    @Column(name = "yearsToComplete")
    private LocalDateTime yearsToComplete;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


//    getter and setter
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public LocalDateTime getYearsToComplete(){
        return yearsToComplete;
    }
    public void setYearsToComplete(LocalDateTime yearsToComplete){
        this.yearsToComplete=yearsToComplete;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }



}
