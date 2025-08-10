package com.swasthajiwan.swasthajiwan.model;


import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id" , length = 20)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role" , nullable = false)
    private RoleType role;

    public enum RoleType{
        patient,doctor,clinic,hospital
    }

//    getter and setter
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }

    public RoleType getRole(){
        return role;
    }
    public void setRole(RoleType role){
        this.role=role;
    }


}
