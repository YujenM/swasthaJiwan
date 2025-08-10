package com.swasthajiwan.swasthajiwan.model;


import jakarta.persistence.*;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @Column(name = "id",unique = true,nullable = false,length = 50)
    private String id;

    @Column(name = "title",columnDefinition = "text")
    private String text;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    @Column(name = "isRead")
    private Boolean isRead;

    @Column(name = "reviewId")
    private String reviewId;

    @ManyToOne
    @JoinColumn(name = "reviewId",referencedColumnName = "id",insertable = false,updatable = false)
    private Review review;

    @Column(name="userId")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id",insertable = false,updatable = false)
    private User user;

    @Column(name = "doctorId")
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "doctorId",referencedColumnName = "id",insertable = false,updatable = false)
    private User doctor;

    @Column(name = "hospitalId")
    private String hospitalId;

    @ManyToOne
    @JoinColumn(name = "hospitalId",referencedColumnName = "id",insertable = false,updatable = false)
    private User hospital;

    @Column(name = "clinicId")
    private String clinicId;

    @ManyToOne
    @JoinColumn(name = "clinicId",referencedColumnName = "id",insertable = false,updatable = false)
    private User clinic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public User getHospital() {
        return hospital;
    }

    public void setHospital(User hospital) {
        this.hospital = hospital;
    }

    public String getClinicId() {
        return clinicId;
    }

    public void setClinicId(String clinicId) {
        this.clinicId = clinicId;
    }

    public User getClinic() {
        return clinic;
    }

    public void setClinic(User clinic) {
        this.clinic = clinic;
    }
}
