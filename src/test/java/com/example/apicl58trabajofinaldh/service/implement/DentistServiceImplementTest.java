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

        System.out.println(dentist);
        System.out.println(dentistRepository.save(dentist));
        System.out.println(dentistService.createDentist(dentist).getIdDentist());
        assertNotNull(dentistService.createDentist(dentist).getIdDentist());
    }

    @Test
    void return_empty_dentist_dto_when_read_a_non_exist_id_dentist() {
        Long id = 666L;
        Mockito.when(dentistRepository.findById(id)).thenReturn(Optional.of(new Dentist()));

        System.out.println(dentistRepository.findById(id));
        System.out.println(dentistService.readDentistById(id).getIdDentist());

        assertNull(dentistService.readDentistById(id).getIdDentist());
    }

    @Test
    void return_dentist_dto_list_when_read_all() {

        assertEquals(Arrays.asList(
                new DentistDTO(1L,"L1","Pepe","Grajales"),
                new DentistDTO(2L,"L2","Paula","Mora"),
                new DentistDTO(3L,"L3","Juliana","Restrepo")
        ), dentistService.readAllDentist());
    }



}