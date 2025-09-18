package com.swasthajiwan.swasthajiwan.dto;

import com.swasthajiwan.swasthajiwan.model.Admin;

public class AdminLoginResponse {
    private Admin admin;
    private String token;

    public AdminLoginResponse(Admin admin, String token) {
        this.admin = admin;
        this.token = token;
    }

    public Admin getAdmin() {
        return admin;
    }

    public String getToken() {
        return token;
    }
}
