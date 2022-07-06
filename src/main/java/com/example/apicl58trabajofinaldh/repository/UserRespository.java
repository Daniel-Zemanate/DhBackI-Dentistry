package com.example.apicl58trabajofinaldh.repository;

import com.example.apicl58trabajofinaldh.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findByUsername (String username);
}
