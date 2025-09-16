package com.swasthajiwan.swasthajiwan.dto;

import java.time.LocalDateTime;

public class AddSpecialization {
    private String name;
    private String description;
    private LocalDateTime yearsToComplete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getYearsToComplete() {
        return yearsToComplete;
    }

    public void setYearsToComplete(LocalDateTime yearsToComplete) {
        this.yearsToComplete = yearsToComplete;
    }
}
