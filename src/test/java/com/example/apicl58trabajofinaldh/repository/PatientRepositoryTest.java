package com.example.apicl58trabajofinaldh.repository;

import com.example.apicl58trabajofinaldh.model.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void find_a_patient_by_dni_equals_to_patient_created() {
        Patient patient = new Patient();
        patient.setDni(1000L);
        patient.setName("n1");
        patient.setSurname("s1");
        patient.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));

        assertEquals(patient.getDni(), patientRepository.save(patient).getDni());
    }

    @Test
    void return_a_non_null_id_when_save_a_patient() {
        Patient patient = new Patient();
        patient.setDni(1000L);
        patient.setName("n1");
        patient.setSurname("s1");
        patient.setRegistrationDate(Timestamp.valueOf(LocalDateTime.now()));

        assertNotNull(patientRepository.save(patient).getIdPatient());
    }
}