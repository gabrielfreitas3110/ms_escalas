package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.RegimeJornadaTrabalho;
import com.example.ms_escalas.Escalas.service.RegimeJornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("regime-jornada-trabalho")
public class RegimeJornadaTrabalhoController {

    @Autowired
    private RegimeJornadaTrabalhoService regimeJornadaTrabalhoService;

    @PostMapping
    public ResponseEntity<?> criarRegimeJornadaTrabalho(@RequestBody RegimeJornadaTrabalho regimeJornadaTrabalhoInput) {
        RegimeJornadaTrabalho regimeJornadaTrabalho = regimeJornadaTrabalhoService.salvaRegimeJornadaTrabalho(regimeJornadaTrabalhoInput);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/regime-jornada-trabalho/{id}")
                .buildAndExpand(regimeJornadaTrabalho.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegimeJornadaTrabalho> buscarPeloId(@PathVariable("id") Long id) {
        RegimeJornadaTrabalho regimeJornadaTrabalho = regimeJornadaTrabalhoService.buscarPorId(id);
        return ResponseEntity.ok().body(regimeJornadaTrabalho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegimeJornadaTrabalho> atualizaRegimeJornadaTrabalho(
            @PathVariable("id") Long id,
            @RequestBody RegimeJornadaTrabalho regimeJornadaTrabalhoInput) {
        RegimeJornadaTrabalho regimeJornadaTrabalho = regimeJornadaTrabalhoService.atualizar(id, regimeJornadaTrabalhoInput);
        return ResponseEntity.ok().body(regimeJornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaRegimeJornadaTrabalho(@PathVariable("id") Long id) {
        regimeJornadaTrabalhoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
