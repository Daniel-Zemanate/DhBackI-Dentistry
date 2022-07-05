package com.example.apicl58trabajofinaldh.service;

import com.example.apicl58trabajofinaldh.model.dto.PatientDTO;
import com.example.apicl58trabajofinaldh.model.dto.TurnDTO;
import com.example.apicl58trabajofinaldh.model.entity.Turn;

import java.util.List;

public interface TurnServiceInterface {


    TurnDTO createTurn(Turn turn);
    TurnDTO readTurnById(Long id);
    List<TurnDTO> readAllTurn();
    List<TurnDTO> readAllTurnByDentistId(Long id);
    List<TurnDTO> readAllTurnByPatientId(Long id);
    TurnDTO updateTurn(Turn turn);
    TurnDTO deleteTurnById(Long id);
}
