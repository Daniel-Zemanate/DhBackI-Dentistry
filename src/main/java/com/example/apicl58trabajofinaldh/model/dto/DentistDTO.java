package com.example.apicl58trabajofinaldh.model.dto;

import com.example.apicl58trabajofinaldh.model.entity.Turn;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistDTO {

    private Long idDentist;
    private String licensePlate;
    private String name;
    private String surname;
}
