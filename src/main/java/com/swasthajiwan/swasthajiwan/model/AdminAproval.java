package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "adminAproval")
public class AdminAproval {
    @Id
    @Column(name = "id",updatable = false,nullable = false)
    private String id;

    @Column(name = "adminId")
    private String adminId;

    @ManyToOne
    @JoinColumn(name = "adminId",referencedColumnName = "id",insertable = false,updatable = false)
    private Admin admin;

    @Column(name = "doctorId")
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "id",insertable = false,updatable = false)
    private User doctor;

    @Column(name = "hospitalId")
    private String hospitalId;

    @ManyToOne
    @JoinColumn(name = "hospitalId",referencedColumnName ="id",insertable = false,updatable = false)
    private User hospital;

    @Column(name = "clinicId")
    private String clinicId;

    @ManyToOne
    @JoinColumn(name = "clinicId",referencedColumnName = "id",insertable = false,updatable = false)
    private User clinic;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public enum Status{
        Accepted,Pending,Rejected
    }

    @Column(name = "remarks",columnDefinition = "Text")
    private String remarks;


    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
