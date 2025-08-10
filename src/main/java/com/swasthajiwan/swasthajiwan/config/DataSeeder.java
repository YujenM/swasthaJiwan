package com.swasthajiwan.swasthajiwan.config;

import com.swasthajiwan.swasthajiwan.model.User;
import com.swasthajiwan.swasthajiwan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        return args->{
            String userEmail="maharjanyuzen@gmail.com";
            if(userRepository.findByEmail(userEmail).isEmpty()){
                User user=new User();
                user.setId("swastha1");
                user.setFullName("Yujen Maharjan");
                user.setEmail(userEmail);
                user.setPassword("Iambatman");
                user.setCreatedAt(LocalDateTime.now());
                userRepository.save(user);
                System.out.println("user Created");
            }
        };
    }
}
