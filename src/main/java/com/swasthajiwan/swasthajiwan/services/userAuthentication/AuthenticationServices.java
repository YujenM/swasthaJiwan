package com.swasthajiwan.swasthajiwan.services.userAuthentication;

import com.swasthajiwan.swasthajiwan.dto.LoginRequest;
import com.swasthajiwan.swasthajiwan.dto.UserRequest;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthenticationServices {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthenticationServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest request) {
        try {
            // Basic validations
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new RuntimeException("Email cannot be null or empty");
            }
            if (request.getFullName() == null || request.getFullName().trim().isEmpty()) {
                throw new RuntimeException("Full name cannot be null or empty");
            }
            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                throw new RuntimeException("Password cannot be null or empty");
            }

            // Check for duplicate email
            userRepository.findByEmail(request.getEmail())
                    .ifPresent(u -> {
                        throw new RuntimeException("Email Already Exists");
                    });

            // Create user with hashed password
            String userID = "SwasthaUser" + UUID.randomUUID();
            User user = new User();
            user.setId(userID);
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword()); // Hash here
            user.setCreatedAt(LocalDateTime.now());

            return userRepository.save(user);

        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Error creating user: " + ex.getMessage());
        }
    }

    public User login(LoginRequest request) {
        try {
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new RuntimeException("Email cannot be null or empty");
            }
            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                throw new RuntimeException("Password cannot be null or empty");
            }
            System.out.println("This--->"+request.getEmail()+request.getPassword());

            // Find user by email
            User user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new RuntimeException("Invalid email or password"));
            System.out.println(user.getPassword());
            // Check hashed password

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new RuntimeException("Invalid email or password");
            }

            return user;

        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Error logging in: " + ex.getMessage());
        }
    }
}
