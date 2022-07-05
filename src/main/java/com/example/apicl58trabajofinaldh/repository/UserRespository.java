package com.example.apicl58trabajofinaldh.repository;

import com.example.apicl58trabajofinaldh.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {

    User findByUsername (String username);
}
