package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "doctorWorkAtClinic")
public class DoctorWorkAtClinic {
    @Id
    @Column(name = "id",nullable = false,unique = true,length = 50)
    private String id;

    @Column(name = "doctorId",nullable = false)
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "id",updatable = false,insertable = false)
    private User doctor;

    @Column(name = "clinicId")
    private String clinicId;

    @ManyToOne
    @JoinColumn(name = "clinicId",referencedColumnName = "id", insertable = false, updatable = false)
    private User clinic;

    @Column(name = "assignedAt")
    private LocalDateTime assignedAt;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

//    getter and setter

    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getDoctorId(){
        return  doctorId;
    }
    public void setDoctorId(String doctorId){
        this.doctorId=doctorId;
    }
    public User getDoctor(){
        return doctor;
    }
    public void setDoctor(User doctor){
        this.doctor=doctor;
    }
    public User getClinic(){
        return clinic;
    }
    public void setClinic(User clinic){
        this.clinic=clinic;
    }
    public LocalDateTime getAssignedAt(){
        return assignedAt;
    }
    public void setAssignedAt(LocalDateTime assignedAt){
        this.assignedAt=assignedAt;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }

}
