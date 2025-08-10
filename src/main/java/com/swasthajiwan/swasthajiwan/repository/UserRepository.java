package com.swasthajiwan.swasthajiwan.repository;

import com.swasthajiwan.swasthajiwan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE :email IS NOT NULL AND u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
}
