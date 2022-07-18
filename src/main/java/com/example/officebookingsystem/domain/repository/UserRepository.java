package com.example.officebookingsystem.domain.repository;

import com.example.officebookingsystem.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    Optional<User> findUserByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
