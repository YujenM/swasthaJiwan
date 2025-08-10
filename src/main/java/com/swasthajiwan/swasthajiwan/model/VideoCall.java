package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "videoCall")
public class VideoCall {
    @Id
    @Column(name = "id",nullable = false,length = 50)
    private String id;

    @Column(name ="callerId" )
    private String callerId;

    @ManyToOne
    @JoinColumn(name = "callerId",referencedColumnName = "id",insertable = false,updatable = false)
    private User caller;

    @Column(name = "receiverId",nullable = false)
    private String receiverId;

    @ManyToOne
    @JoinColumn(name = "receiverId",referencedColumnName = "id",insertable = false,updatable = false)
    private User receiver;

    @Column(name = "startedt")
    private LocalDateTime startedAt;

    @Column(name = "endedAt")
    private LocalDateTime endedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private Status status=Status.pending;
    public enum Status{
        pending,accepted,rejected,ended,missed
    }
    @Column(name = "createdAt",nullable = false)
    private LocalDateTime cretedAt;

//    getter and setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public User getCaller() {
        return caller;
    }

    public void setCaller(User caller) {
        this.caller = caller;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCretedAt() {
        return cretedAt;
    }

    public void setCretedAt(LocalDateTime cretedAt) {
        this.cretedAt = cretedAt;
    }
}
