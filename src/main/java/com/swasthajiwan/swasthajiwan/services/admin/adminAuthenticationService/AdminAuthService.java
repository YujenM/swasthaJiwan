package com.swasthajiwan.swasthajiwan.services.admin.adminAuthenticationService;

import com.swasthajiwan.swasthajiwan.dto.AdminLoginResponse;
import com.swasthajiwan.swasthajiwan.dto.LoginRequest;
import com.swasthajiwan.swasthajiwan.dto.LoginResponse;
import com.swasthajiwan.swasthajiwan.methods.CheckUserValidate;
import com.swasthajiwan.swasthajiwan.model.Admin;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.repository.AdminRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
@Service
public class AdminAuthService {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms}")
    private long jwtExpirationMs;

    public AdminAuthService(AdminRepository adminRepository){
        this.adminRepository=adminRepository;
    }
    public AdminLoginResponse adminLogin(LoginRequest request){
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email cannot be null or empty");
        }

        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new RuntimeException("Password cannot be null or empty");
        }

        Admin admin=adminRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("Admin not found"));

        if (!passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder()
                .setSubject(admin.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return new AdminLoginResponse(admin,token);



    }
}
