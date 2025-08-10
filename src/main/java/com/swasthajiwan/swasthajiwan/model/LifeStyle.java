package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

@Entity
@Table(name = "life_style")
public class LifeStyle {
    @Id
    @Column(name = "user_id")
    private String userId;

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "is_smoking")
    private Boolean isSmoking;

    @Column(name = "is_drinking")
    private Boolean isDrinking;

    @Column(name = "drugs_id")
    private String drugsId;

    @ManyToOne
    @JoinColumn(name = "drugs_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Drug drugs;

    @Column(name = "medicine_id")
    private String medicineId;

    @ManyToOne
    @JoinColumn(name = "medicine_id", referencedColumnName = "id", insertable = false,updatable = false)
    private Medicine medicine;

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
    public Boolean getIsSmoking(){
        return isSmoking;
    }
    public void setIsSmoking(Boolean isSmoking){
        this.isSmoking=isSmoking;
    }
    public Boolean getIsDrinking(){
        return isDrinking;
    }
    public void setIsDrinking(Boolean isDrinking){
        this.isDrinking=isDrinking;
    }
    public String getDrugsId(){
        return drugsId;
    }
    public void setDrugsId(String drugsId){
        this.drugsId=drugsId;
    }
    public Drug getDrugs() {
        return drugs;
    }

    public void setDrugs(Drug drugs) {
        this.drugs = drugs;
    }

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
