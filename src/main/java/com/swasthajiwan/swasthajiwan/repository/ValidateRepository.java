package com.swasthajiwan.swasthajiwan.repository;

import com.swasthajiwan.swasthajiwan.model.Validate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidateRepository extends JpaRepository<Validate ,String> {
    Optional<Validate> findByUserId(String userId);
}
