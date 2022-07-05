package com.example.apicl58trabajofinaldh.service.implement;

import com.example.apicl58trabajofinaldh.model.dto.DentistDTO;
import com.example.apicl58trabajofinaldh.model.entity.Dentist;
import com.example.apicl58trabajofinaldh.model.entity.Patient;
import com.example.apicl58trabajofinaldh.model.entity.Turn;
import com.example.apicl58trabajofinaldh.repository.DentistRepository;
import com.example.apicl58trabajofinaldh.service.DentistServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
//TODO:HACER TEST DE IMPLEMENTACIONES

//@DataJpaTest
@SpringBootTest
class DentistServiceImplementTest {


    private DentistServiceImplement dentistService;
    private ObjectMapper mapper;
    private DentistRepository dentistRepository;

    @BeforeEach
    void setUp() {
        dentistRepository = Mockito.mock(DentistRepository.class);
        mapper = new ObjectMapper();
        dentistService = new DentistServiceImplement(dentistRepository, mapper);

        Mockito.when(dentistRepository.findAll()).thenReturn(Arrays.asList(
                new Dentist(1L,"L1","Pepe","Grajales",null),
                new Dentist(2L,"L2","Paula","Mora",null),
                new Dentist(3L,"L3","Juliana","Restrepo",null)
        ));
    }

    @Test
    void return_dentist_dto_when_a_dentist_is_created() {
        Dentist dentist = new Dentist(null,"L1","N1","S1",null);
        Mockito.when(dentistRepository.save(dentist)).thenReturn(new Dentist(1L,"L1","N1","S1",null));

        assertNotNull(dentistService.createDentist(dentist).getIdDentist());
    }

    //TODO: REVISAR TESTS DESDE AQUI
    @Test
    void return_empty_dentist_dto_when_a_dentist_is_created_with_repeated_licence() {
        Dentist dentist = new Dentist(null, "L1","N1","S1",null);

//        dentistService.readDentistByLicensePlate("L1");
        Mockito.when(dentistRepository.findByLicensePlate(null)).thenReturn(Optional.of(new Dentist()));

//        Mockito.when(dentistRepository.findByLicensePlate("L1")).thenReturn(Optional.of(new Dentist(1L,"L1","Pepe","Grajales",null)));

        Mockito.when(dentistRepository.save(dentist)).thenReturn(new Dentist(null,null,null,null,null));



//        assertNull(dentistService.createDentist(dentist).getIdDentist());
        assertEquals(3,dentistService.readAllDentist().size());
        assertEquals(null,dentistService.createDentist(dentist).getIdDentist());
    }

    @Test
    void return_empty_dentist_dto_when_find_a_dentist_by_null_id() {
        Dentist dentist = new Dentist();
        Long id = null;
        Mockito.when(dentistRepository.findById(id)).thenReturn(Optional.of(dentist));

        assertNull(dentistService.readDentistById(id).getIdDentist());
    }

    @Test
    void return_empty_dentist_dto_when_find_a_dentist_by_negative_id() {
        Dentist dentist = new Dentist();
        Long id = -1L;
        Mockito.when(dentistRepository.findById(id)).thenReturn(Optional.of(dentist));

        assertNull(dentistService.readDentistById(id).getIdDentist());
    }

    @Test
    void return_empty_dentist_dto_when_a_dentist_is_deleted_by_null_id() {
        Dentist dentist = new Dentist();
        Long id = null;
        Mockito.when(dentistRepository.findById(id)).thenReturn(Optional.of(dentist));

        assertNull(dentistService.deleteDentistById(id).getIdDentist());
    }


    private List getLicences(List<Dentist> dentistList){
        return dentistList.stream().map(Dentist::getLicensePlate).collect(Collectors.toList());
    }



}