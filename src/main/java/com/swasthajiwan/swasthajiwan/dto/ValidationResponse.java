package com.swasthajiwan.swasthajiwan.dto;

import java.time.LocalDateTime;

public class ValidationResponse {
    private String userId;
    private LocalDateTime createdAt;
    private Boolean is_validate;
    private String reason;

//    constructor
    public ValidationResponse(String userId,LocalDateTime createdAt, Boolean is_validate,String reason){
        this.userId=userId;
        this.createdAt=createdAt;
        this.is_validate=is_validate;
        this.reason=reason;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIs_validate() {
        return is_validate;
    }

    public void setIs_validate(Boolean is_validate) {
        this.is_validate = is_validate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
