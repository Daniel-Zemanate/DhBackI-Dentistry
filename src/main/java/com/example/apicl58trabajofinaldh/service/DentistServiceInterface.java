package com.example.apicl58trabajofinaldh.service;

import com.example.apicl58trabajofinaldh.model.dto.DentistDTO;
import com.example.apicl58trabajofinaldh.model.entity.Dentist;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DentistServiceInterface {


    DentistDTO createDentist(Dentist dentist);
    DentistDTO readDentistById(Long id);
    DentistDTO readDentistByLicensePlate(String licencePlate);
    List<DentistDTO> readAllDentist();
    DentistDTO updateDentist(Dentist dentist);
    DentistDTO deleteDentistById(Long id);
}
