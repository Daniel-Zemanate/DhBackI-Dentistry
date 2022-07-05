package com.example.apicl58trabajofinaldh.model.dto;

import com.example.apicl58trabajofinaldh.model.entity.Dentist;
import com.example.apicl58trabajofinaldh.model.entity.Patient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnDTO {

    private Long idTurn;
    private Timestamp date;
    private Dentist dentist;
    private Patient patient;
}
