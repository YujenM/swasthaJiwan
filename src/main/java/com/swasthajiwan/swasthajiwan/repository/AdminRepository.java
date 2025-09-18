package com.swasthajiwan.swasthajiwan.repository;

import com.swasthajiwan.swasthajiwan.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findByEmail(String email);
}
