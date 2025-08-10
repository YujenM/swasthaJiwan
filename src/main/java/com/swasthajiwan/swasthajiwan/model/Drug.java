package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "drugs")
public class Drug {
    @Id
    @Column(name = "id",length = 50)
    private String id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "description", columnDefinition = "Text")
    private String description;

    @Column(name = "image",length = 500)
    private String image;

    @Column(name = "healthRisk",columnDefinition = "text")
    private String healthRisk;

    @Column(name="createdAt")
    private LocalDateTime createdAt;


//    getter and setter
    public String getId(){
        return id;
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

    public String image(){
        return image;
    }
    public void setImage(String image){
        this.image=image;
    }

    public String getHealthRisk(){
        return healthRisk;
    }
    public void setHealthRisk(String healthRisk){
        this.healthRisk=healthRisk;
    }
    public LocalDateTime getCreatedAt(){
        return  createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}
