package com.example.apicl58trabajofinaldh.repository;

import com.example.apicl58trabajofinaldh.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> findByDni(Long dni);
}
