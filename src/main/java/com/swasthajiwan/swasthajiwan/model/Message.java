package com.swasthajiwan.swasthajiwan.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @Column(name = "id",length = 50)
    private String id;

    @Column(name = "conversationId",nullable = false)
    private String conversationId;

    @ManyToOne
    @JoinColumn(name = "conversationId",referencedColumnName = "id",insertable = false,updatable = false)
    private Conversation conversation;

    @Column(name = "senderId",nullable = false)
    private String senderId;

    @ManyToOne
    @JoinColumn(name = "senderId",referencedColumnName = "id",insertable = false,updatable = false)
    private User sender;

    @Column(name = "content", nullable = false,columnDefinition = "text")
    private String content;

    @Column(name = "isRead",nullable = false)
    private Boolean isRead=false;

    @Column(name = "createdAt",nullable = false)
    private LocalDateTime createdAt;

//    getter and setter


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
