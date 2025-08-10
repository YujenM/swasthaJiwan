package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_additional_info")
public class UserAdditionalInfo {
    @Id
    @Column(name = "user_id")
    private String userId;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "bloodtype")
    private BloodType bloodtype;
    public enum BloodType{
        A_POSITIVE("A+"),A_NEGATIVE("A-"),
        B_POSITIVE("B+"), B_NEGATIVE("B-"),
        AB_POSITIVE("AB+"), AB_NEGATIVE("AB-"),
        O_POSITIVE("O+"), O_NEGATIVE("O-");


        private final String value;
        BloodType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
    }
    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "bmi")
    private Double bmi;

    @Column(name = "profile_picture",length = 500)
    private String profiePicture;
//getter and setter
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
    public BloodType getBloodtype(){
        return bloodtype;
    }
    public void  setBloodtype(BloodType bloodtype){
        this.bloodtype=bloodtype;
    }
    public Double getHeight(){
        return height;
    }
    public void setHeight(Double height){
        this.height=height;
    }
    public Double getBmi(){
        return bmi;
    }
    public void setWeight(Double bmi){
        this.bmi=bmi;
    }
    public String getProfiePicture(){
        return profiePicture;
    }
    public void setProfiePicture(String profiePicture){
        this.profiePicture=profiePicture;
    }
}
