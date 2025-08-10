package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "doctorAdditionalInfo")
public class DoctorAdditionalInfo {
    @Id
    @Column(name = "userId")
    private String userId;

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "specialization_id", insertable = false, updatable = false)
    private String specializationId;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @Column(name = "licenseNumber",length=100)
    private String licenseNumber;

    @Column(name = "bio",columnDefinition = "Text")
    private String bio;

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
    public String getSpecializationId(){
        return specializationId;
    }
    public void setSpecializationId(String specializationId){
        this.specializationId=specializationId;
    }
    public Specialization getSpecialization(){
        return specialization;
    }
    public void setSpecialization(Specialization specialization){
        this.specialization=specialization;
    }
    public String getLicenseNumber(){
        return licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber=licenseNumber;
    }
    public String getBio(){
        return bio;
    }
    public void setBio(String bio){
        this.bio=bio;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}
