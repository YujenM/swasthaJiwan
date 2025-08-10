package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "clinicInformation")
public class clinicInformation {
    @Id
    @Column(name = "userId",nullable = false)
    private String userId;

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "address",length = 50)
    private String address;

    @Column(name = "registrationNo",length = 50)
    private String registrationNo;

    @Column(name = "number",length = 50)
    private String number;

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
    public String getAddress(){
        return address;
    }
    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getRegistrationNo(){
        return registrationNo;
    }
    public void setRegistrationNo(String registrationNo){
        this.registrationNo=registrationNo;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public  void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }

}
