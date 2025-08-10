package com.swasthajiwan.swasthajiwan.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id",unique = true,nullable = false,length = 50)
    private String id;

    @Column(name="userId")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "doctorId")
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "id",insertable = false,updatable = false)
    private User doctor;

    @Column(name = "hospitalId")
    private String hospitalId;

    @ManyToOne
    @JoinColumn(name = "hospitalId",referencedColumnName = "id",insertable = false,updatable = false)
    private User hospital;

    @Column(name = "clinicId")
    private String clinicId;

    @ManyToOne
    @JoinColumn(name = "clinicId",referencedColumnName = "id",insertable = false,updatable = false)
    private User clinic;

    @Column(name = "title",columnDefinition = "text")
    private String title;

    @Column(name = "message",columnDefinition = "text")
    private String message;

    @Column(name = "isRead")
    private Boolean isRead;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public User getHospital() {
        return hospital;
    }

    public void setHospital(User hospital) {
        this.hospital = hospital;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public User getClinic() {
        return clinic;
    }

    public void setClinic(User clinic) {
        this.clinic = clinic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
