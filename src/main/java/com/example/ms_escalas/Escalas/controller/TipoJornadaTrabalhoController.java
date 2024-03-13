package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.TipoJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.TipoJornadaTrabalhoInputDTO;
import com.example.ms_escalas.Escalas.service.TipoJornadaTrabalhoService;
import com.example.ms_escalas.Escalas.service.TipoJornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequestMapping("tipo-jornada-trabalho")
@RestController
public class TipoJornadaTrabalhoController {


    @Autowired
    private TipoJornadaTrabalhoService tipoJornadaTrabalhoService;

    @PostMapping
    public ResponseEntity<?> criarTipoJornadaTrabalho(@RequestBody TipoJornadaTrabalhoInputDTO tipoJornadaTrabalhoInput) {
        TipoJornadaTrabalho TipoJornadaTrabalho = tipoJornadaTrabalhoService.salvaTipoJornadaTrabalho(tipoJornadaTrabalhoInput);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/carga-horaria-/{id}")
                .buildAndExpand(TipoJornadaTrabalho.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoJornadaTrabalho> buscarPeloId(@PathVariable("id") Long id) {
        TipoJornadaTrabalho TipoJornadaTrabalho = tipoJornadaTrabalhoService.buscarPorId(id);
        return ResponseEntity.ok().body(TipoJornadaTrabalho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoJornadaTrabalho> atualizaTipoJornadaTrabalho(
            @PathVariable("id") Long id,
            @RequestBody TipoJornadaTrabalho TipoJornadaTrabalhoInput) {
        TipoJornadaTrabalho TipoJornadaTrabalho = tipoJornadaTrabalhoService.atualizar(id, TipoJornadaTrabalhoInput);
        return ResponseEntity.ok().body(TipoJornadaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaTipoJornadaTrabalho(@PathVariable("id") Long id) {
        tipoJornadaTrabalhoService.delete(id);
        return ResponseEntity.ok().build();
    }

}
