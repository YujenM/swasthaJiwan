package com.swasthajiwan.swasthajiwan.config;

import com.swasthajiwan.swasthajiwan.model.Role;
import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.repository.RoleRepository;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, RoleRepository roleRepository) {
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
