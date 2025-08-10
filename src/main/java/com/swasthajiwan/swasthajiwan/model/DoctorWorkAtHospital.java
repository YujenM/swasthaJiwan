package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "doctorWorkAtHospital")
public class DoctorWorkAtHospital {
    @Id
    @Column(name = "id",unique = true,nullable = false,length = 50)
    private String id;

    @Column(name = "doctorId",nullable = false)
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "id",insertable = false,updatable = false)
    private User doctor;

    @Column(name = "hospitalId")
    private String hospitalId;

    @ManyToOne
    @JoinColumn(name = "hospitalId",referencedColumnName = "id",insertable = false,updatable = false)
    private  User hospital;

    @Column(name = "assignedAt")
    private LocalDateTime assignedAt;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;


//getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getAssignedAt() {
        return assignedAt;
    }

    public void setAssignedAt(LocalDateTime assignedAt) {
        this.assignedAt = assignedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
