package com.swasthajiwan.swasthajiwan.config;

import com.swasthajiwan.swasthajiwan.model.Admin;
import com.swasthajiwan.swasthajiwan.model.Role;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.repository.AdminRepository;
import com.swasthajiwan.swasthajiwan.repository.RoleRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {
    Dotenv dotenv =Dotenv.load();

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository,
                                   AdminRepository adminRepository) {
        return args -> {
            seedRole(roleRepository, "R1", Role.RoleType.patient);
            seedRole(roleRepository, "R2", Role.RoleType.doctor);
            seedRole(roleRepository, "R3", Role.RoleType.clinic);
            seedRole(roleRepository, "R4", Role.RoleType.hospital);

            String userEmail = "maharjanyuzen@gmail.com";
            if (userRepository.findByEmail(userEmail).isEmpty()) {
                User user = new User();
                user.setId("swastha1");
                user.setFullName("Yujen Maharjan");
                user.setEmail(userEmail);
                user.setPassword("Iambatman");
                user.setCreatedAt(LocalDateTime.now());
                userRepository.save(user);
                System.out.println("Default user created");
            }
            String adminEmail=dotenv.get("ADMIN_EMAIL");
            String adminPassword=dotenv.get("ADMIN_PASSWORD");
            System.out.println("This-->"+adminEmail+adminPassword);
            if(adminRepository.findByEmail(adminEmail).isEmpty()){
                Admin admin = new Admin();
                admin.setId("swasthaAdmin1");
                admin.setName("admin");
                admin.setEmail(adminEmail);
                BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
                admin.setPassword(encoder.encode(adminPassword));
                admin.setCreatedAt(LocalDateTime.now());
                adminRepository.save(admin);
                System.out.println("Admin account created");
            }
        };
    }

    private void seedRole(RoleRepository roleRepository, String id, Role.RoleType type) {
        roleRepository.findByRole(type).orElseGet(() -> {
            Role role = new Role();
            role.setId(id);
            role.setRole(type);
            System.out.println("Seeding role: " + type);
            return roleRepository.save(role);
        });
    }




}
