package com.swasthajiwan.swasthajiwan.controller.admin.authentication;

import com.swasthajiwan.swasthajiwan.dto.LoginRequest;
import com.swasthajiwan.swasthajiwan.dto.LoginResponse;
import com.swasthajiwan.swasthajiwan.services.admin.adminAuthenticationService.AdminAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/admin")
public class AdminAuth {
    private final AdminAuthService adminAuthService;

    public AdminAuth(AdminAuthService adminAuthService){
        this.adminAuthService=adminAuthService;
    }

    @PostMapping("/login")
    public ResponseEntity<?>register(@RequestBody LoginRequest request){
        try{
            LoginResponse response=adminAuthService.adminLogin(request);
            return ResponseEntity.ok(response);
        }catch (RuntimeException ex){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error",ex.getMessage()));
        }catch(Exception ex){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error","Something went wrong"));
        }
    }

}
