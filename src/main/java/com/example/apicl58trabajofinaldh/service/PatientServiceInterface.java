package com.example.apicl58trabajofinaldh.service;

import com.example.apicl58trabajofinaldh.model.dto.DentistDTO;
import com.example.apicl58trabajofinaldh.model.dto.PatientDTO;
import com.example.apicl58trabajofinaldh.model.entity.Patient;

import java.util.List;

public interface PatientServiceInterface {


    PatientDTO createPatient(Patient patient);
    PatientDTO readPatientById(Long id);
    PatientDTO readPatientByDni(Long dni);
    List<PatientDTO> readAllPatient();
    PatientDTO updatePatient(Patient patient);
    PatientDTO deletePatientById(Long id);
}
