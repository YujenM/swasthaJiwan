package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "medicine")
public class Medicine {
    @Id
    @Column(name = "id", length = 50)
    private String id;

    @Column(name = "name",length = 50)
    private String name;

    @Column(name = "description",length = 50)
    private String description;

    @Column(name = "image",length = 100)
    private String image;

    @Column(name = "generic_name",length = 50)
    private String genericName;

    @Column(name = "brand_name", length = 50)
    private String brandName;

    @Column(name = "dosage_form",length = 50)
    private String dosageForm;

    @Column(name ="Strength",length = 50)
    private String strength;

    @Column(name = "sideEffects",columnDefinition = "Text")
    private String sidEffects;

    @Column(name = "contradiction",columnDefinition = "Text")
    private String contradiction;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

//    getter and setter

    public String getId(){
        return  id;
    }
    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image=image;
    }

    public String getGenericName(){
        return genericName;
    }
    public void setGenericName(String genericName){
        this.genericName=genericName;
    }

    public String getBrandName(){
        return brandName;
    }
    public void setBrandName(String brandName){
        this.brandName=brandName;
    }

    public String getDosageForm(){
        return dosageForm;
    }
    public void setDosageForm(String dosageForm){
        this.dosageForm=dosageForm;
    }
     public String getStrength(){
        return strength;
     }
     public void setStrength(String strength){
        this.strength=strength;
     }

     public String getSidEffects(){
        return sidEffects;
     }
     public void setSidEffects(String sidEffects){
        this.sidEffects=sidEffects;
     }

     public String getContradiction(){
        return contradiction;
     }
     public void setContradiction(String contradiction){
        this.contradiction=contradiction;
     }

     public LocalDateTime getCreatedAt(){
        return  createdAt;
     }
     public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
     }



}

