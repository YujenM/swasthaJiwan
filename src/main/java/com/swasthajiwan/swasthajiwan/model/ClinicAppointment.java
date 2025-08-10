package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clinicAppointment")
public class ClinicAppointment {
    @Id
    @Column(name = "id",nullable = false,unique = true,length = 50)
    private String id;

    @Column(name = "UserId")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column (name = "clinicId")
    private String clinicId;

    @ManyToOne
    @JoinColumn(name = "clinicId",referencedColumnName = "id",insertable = false,updatable = false)
    private User clinic;

    @Column(name = "doctorId")
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "id", insertable = false,updatable = false)
    private User doctor;

    @Column(name = "date")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public enum Status{
        accepted,pending,rejected
    }
    @Column(name = "reason",columnDefinition = "Text")
    private String reason;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

//    getter and setter


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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
