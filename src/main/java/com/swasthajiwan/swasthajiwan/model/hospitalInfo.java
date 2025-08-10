package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitalInfo")
public class hospitalInfo {
    @Id
    @Column(name = "userId")
    private String userId;

    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "address",length = 50)
    private String address;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @Column(name = "number",length = 50)
    private String number;

    @Column(name = "registrationNo",length = 100)
    private String registrationNo;

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
    public void setAddress(String address){
        this.address=address;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getNumber(){
        return  number;
    }
    public void setNumber(String number){
        this.number=number;
    }
    public String getRegistrationNo(){
        return  registrationNo;
    }
    public void setRegistrationNo(String registrationNo){
        this.registrationNo=registrationNo;
    }
}
