package com.example.ms_escalas.Escalas.controller;


import com.example.ms_escalas.Escalas.model.ParametroJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.ParametroJornadaTrabalhoInputDTO;
import com.example.ms_escalas.Escalas.service.ParametroJornadaTrabalhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("parametro-jornada-trabalho")
public class ParametroJornadaTrabahloController {

    @Autowired
    private ParametroJornadaTrabalhoService parametroJornadaTrabalhoService;

    @PostMapping
    public ResponseEntity<?> criarParametroJornadaTrabalho(@Valid @RequestBody ParametroJornadaTrabalhoInputDTO parametroJornadaTrabalhoInputDTO) {
        ParametroJornadaTrabalho parametroJornadaTrabalho = parametroJornadaTrabalhoService.criarParametro(parametroJornadaTrabalhoInputDTO);
        URI location = UriComponentsBuilder
                .fromUriString("https://localhost:8080/parametro-jornada-trabalho")
                .buildAndExpand(parametroJornadaTrabalho.getId()).toUri();
        return ResponseEntity.created(location).build();

    }
}
