package com.swasthajiwan.swasthajiwan.model;


import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @Column(name = "id" , unique = true,nullable = false,length = 50)
    private String id;

    @Column(name = "participant1Id")
    private String participant1Id;

    @ManyToOne
    @JoinColumn(name = "participant1Id",referencedColumnName = "id",insertable = false,updatable = false)
    private User participant1;

    @Column(name = "participant2Id")
    private String participant2Id;

    @ManyToOne
    @JoinColumn(name = "participant2Id",referencedColumnName = "id",insertable = false,updatable = false)
    private User participant2;

    @Column(name = "startedAt",nullable = false)
    private LocalDateTime startedAt;

    @Column(name = "lastMessageAt")
    private LocalDateTime lastMessageAt;

    @Column(name="isActive")
    private Boolean isActive;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

//    getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParticipant1Id() {
        return participant1Id;
    }

    public void setParticipant1Id(String participant1Id) {
        this.participant1Id = participant1Id;
    }

    public User getParticipant1() {
        return participant1;
    }

    public void setParticipant1(User participant1) {
        this.participant1 = participant1;
    }

    public String getParticipant2Id() {
        return participant2Id;
    }

    public void setParticipant2Id(String participant2Id) {
        this.participant2Id = participant2Id;
    }

    public User getParticipant2() {
        return participant2;
    }

    public void setParticipant2(User participant2) {
        this.participant2 = participant2;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getLastMessageAt() {
        return lastMessageAt;
    }

    public void setLastMessageAt(LocalDateTime lastMessageAt) {
        this.lastMessageAt = lastMessageAt;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
