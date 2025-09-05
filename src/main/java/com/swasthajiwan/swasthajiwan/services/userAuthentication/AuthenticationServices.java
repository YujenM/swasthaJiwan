package com.swasthajiwan.swasthajiwan.services.userAuthentication;

import com.swasthajiwan.swasthajiwan.dto.LoginRequest;
import com.swasthajiwan.swasthajiwan.dto.LoginResponse;
import com.swasthajiwan.swasthajiwan.dto.UserRequest;
import com.swasthajiwan.swasthajiwan.dto.UserResponse;
import com.swasthajiwan.swasthajiwan.model.Role;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.model.UserRole;
import com.swasthajiwan.swasthajiwan.repository.RoleRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRoleRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("userAuthenticationService")
public class AuthenticationServices {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms}")
    private long jwtExpirationMs;

    public AuthenticationServices(UserRepository userRepository,
                                  UserRoleRepository userRoleRepository,
                                  RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(UserRequest request) {
        try {
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new RuntimeException("Email cannot be null or empty");
            }
            if (request.getFullName() == null || request.getFullName().trim().isEmpty()) {
                throw new RuntimeException("Full name cannot be null or empty");
            }
            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                throw new RuntimeException("Password cannot be null or empty");
            }

            userRepository.findByEmail(request.getEmail())
                    .ifPresent(u -> {
                        throw new RuntimeException("Email Already Exists");
                    });

            String userID = "SwasthaUser" + UUID.randomUUID();
            User user = new User();
            user.setId(userID);
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setCreatedAt(LocalDateTime.now());  // ✅ semicolon fixed

            User savedUser = userRepository.save(user);

            Role patientRole = roleRepository.findByRole(Role.RoleType.patient)
                    .orElseThrow(() -> new RuntimeException("Default role 'patient' not found in DB"));

            UserRole userRole = new UserRole();
            userRole.setUserId(savedUser.getId());
            userRole.setRoleId(patientRole.getId());
            userRole.setCreatedAt(LocalDateTime.now());

            userRoleRepository.save(userRole);

            return savedUser;
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Error creating user: " + ex.getMessage());
        }
    }

    public LoginResponse login(LoginRequest request) {
        try {
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new RuntimeException("Email cannot be null or empty");
            }
            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                throw new RuntimeException("Password cannot be null or empty");
            }

            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Invalid email or password"));

            if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
                throw new RuntimeException("Invalid  or Password");
            }

            Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
            String token = Jwts.builder()
                    .setSubject(user.getId())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();

            return new LoginResponse(user, token);
        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Error logging in: " + ex.getMessage());
        }
    }

    public UserResponse getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String role = userRoleRepository.findByUserId(userId).stream()
                .map(userRole -> userRole.getRole().getRole().name())
                .findFirst()
                .orElse(null);


        return new UserResponse(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getCreatedAt(),
                role
        );
    }
}
