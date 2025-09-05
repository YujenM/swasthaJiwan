package com.swasthajiwan.swasthajiwan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }
    private static final List<String> PUBLIC_ROUTES = List.of(
            "/patient/api/auth/register",
            "/patient/api/auth/login",
            "/patient/api/auth/forgot-password" ,
            "/doctor/api/auth/register",
            "/doctor/api/auth/register",
            "/doctor/api/auth/login"
    );
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PUBLIC_ROUTES.toArray(new String[0])).permitAll()// public endpoints
                        .anyRequest().authenticated() // everything else needs login
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(form -> form.disable()) // disable default login page
                .httpBasic(httpBasic -> httpBasic.disable()); // disable HTTP Basic Auth

        return http.build();
    }
}
