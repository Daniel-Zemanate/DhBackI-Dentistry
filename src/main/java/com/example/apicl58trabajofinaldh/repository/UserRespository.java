package com.example.apicl58trabajofinaldh.repository;

import com.example.apicl58trabajofinaldh.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findByUsername (String username);
}
