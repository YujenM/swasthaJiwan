package com.swasthajiwan.swasthajiwan.controller.doctorRoutes.authentication;

import com.swasthajiwan.swasthajiwan.dto.LoginRequest;
import com.swasthajiwan.swasthajiwan.dto.LoginResponse;
import com.swasthajiwan.swasthajiwan.dto.UserRequest;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.services.doctor.authentication.AuthenticationServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/doctor/api/auth")
public class Authentication {

    private final AuthenticationServices authenticationServices;

    public Authentication(AuthenticationServices authenticationServices) {
        this.authenticationServices = authenticationServices;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequest request) {
        try {
            User user = authenticationServices.createUser(request);
            user.setPassword(null); // remove password before sending response
            return ResponseEntity.status(HttpStatus.CREATED).body(user);

        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", ex.getMessage()));
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Something went wrong"));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?>Login(@RequestBody LoginRequest request){
        try{
            LoginResponse response=authenticationServices.login(request);
            if(response.getUser()!=null){
                response.getUser().setPassword(null);
            }
            return ResponseEntity.ok(response);

        }catch(RuntimeException ex){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("Error",ex.getMessage()));
        }catch (Exception ex){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("Error","Something Went Wrong"));
        }
    }
}
