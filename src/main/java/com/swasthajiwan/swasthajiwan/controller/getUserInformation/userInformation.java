package com.swasthajiwan.swasthajiwan.controller.getUserInformation;


import com.swasthajiwan.swasthajiwan.dto.UserResponse;
import com.swasthajiwan.swasthajiwan.services.userAuthentication.AuthenticationServices;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class userInformation {

    private final AuthenticationServices authService;
    public userInformation(AuthenticationServices authService){
        this.authService=authService;
    }
    @GetMapping("/getUser")
    public UserResponse getUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String userId=(String) auth.getPrincipal();
        return authService.getUserById(userId);

    }
}
