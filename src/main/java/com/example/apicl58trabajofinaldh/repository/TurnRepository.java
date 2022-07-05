package com.example.apicl58trabajofinaldh.repository;

import com.example.apicl58trabajofinaldh.model.entity.Dentist;
import com.example.apicl58trabajofinaldh.model.entity.Patient;
import com.example.apicl58trabajofinaldh.model.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnRepository extends JpaRepository<Turn, Long> {

    List<Turn> findByDentist(Dentist dentist);
    List<Turn> findByPatient(Patient patient);
}
