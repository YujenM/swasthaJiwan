package com.swasthajiwan.swasthajiwan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for APIs (important for POST testing in Postman/Bruno)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/register", "/api/auth/login").permitAll() // allow these endpoints
                        .anyRequest().authenticated() // everything else needs login
                )
                .formLogin(login -> login.disable()) // disable Spring login page
                .httpBasic(httpBasic -> httpBasic.disable()); // disable HTTP Basic Auth

        return http.build();
    }
}
