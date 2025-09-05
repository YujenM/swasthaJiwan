package com.swasthajiwan.swasthajiwan.services.doctor.authentication;

import com.swasthajiwan.swasthajiwan.dto.LoginRequest;
import com.swasthajiwan.swasthajiwan.dto.LoginResponse;
import com.swasthajiwan.swasthajiwan.dto.UserRequest;
import com.swasthajiwan.swasthajiwan.methods.CheckUserValidate;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.model.UserRole;
import com.swasthajiwan.swasthajiwan.model.Validate;
import com.swasthajiwan.swasthajiwan.repository.RoleRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRoleRepository;
import com.swasthajiwan.swasthajiwan.model.Role;
import com.swasthajiwan.swasthajiwan.repository.ValidateRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service("doctorAuthenticationService")
public class AuthenticationServices {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationServices.class);
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final ValidateRepository validateRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final CheckUserValidate checkUserValidate;

    public AuthenticationServices(UserRepository userRepository, UserRoleRepository userRoleRepository, RoleRepository roleRepository, ValidateRepository validateRepository,CheckUserValidate checkUserValidate) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
        this.validateRepository=validateRepository;
        this.checkUserValidate=checkUserValidate;

    }

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration-ms}")
    private long jwtExpirationMs;

    public User createUser(UserRequest request) {
        try {
            if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
                throw new RuntimeException("Email cannot be null or empty");
            }
            if (request.getFullName() == null || request.getFullName().isEmpty()) {
                throw new RuntimeException("Full name cannot be empty");
            }
            if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
                throw new RuntimeException("Password cannot be empty");
            }

            userRepository.findByEmail(request.getEmail())
                    .ifPresent(u -> { throw new RuntimeException("Email already exists"); });

            String userId = "SwasthaDoctor" + UUID.randomUUID();
            User user = new User();
            user.setId(userId);
            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            user.setCreatedAt(LocalDateTime.now());

            User savedUser = userRepository.save(user);
            Validate validate= new Validate();
            validate.setUserId(userId);
            validate.setCreatedAt(LocalDateTime.now());
            validate.setIsValidate(false);
            validate.setReason("Require Admin approval");

            validateRepository.save(validate);


            Role doctorRole = roleRepository.findByRole(Role.RoleType.doctor)
                    .orElseThrow(() -> new RuntimeException("Default role `doctor` not found in DB"));

            UserRole userRole = new UserRole();
            userRole.setUserId(savedUser.getId());
            userRole.setRoleId(doctorRole.getId());
            userRole.setCreatedAt(LocalDateTime.now());

            userRoleRepository.save(userRole);

            return savedUser;

        } catch (RuntimeException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new RuntimeException("Error creating user: " + ex.getMessage());
        }
    }

    public LoginResponse login(LoginRequest request){
        if(request.getEmail()==null || request.getEmail().trim().isEmpty()){
            throw  new RuntimeException("Email cannot be null or empty");
        }
        if(request.getPassword()==null || request.getPassword().trim().isEmpty()){
            throw new RuntimeException("password cannot be null or empty");
        }
        User user=userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new RuntimeException("Invalid email or "));
        if(!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid  or Password");
        }
        boolean isValidate= checkUserValidate.isValidate(user.getId());
        if(!isValidate){
            throw  new RuntimeException("Doctor is not validate");
        }
        Key key= Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        String token = Jwts.builder()
                .setSubject(user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        String role=userRoleRepository.findByUserId(user.getId()).stream()
                .map(userRole -> userRole.getRole().getRole().name())
                .findFirst()
                .orElseThrow(()->new RuntimeException("Role not assigned to user"));
        if(role!="doctor"){
            throw  new RuntimeException("Only doctor can access the portal");
        }
        return new LoginResponse(user,token);
    }
}
