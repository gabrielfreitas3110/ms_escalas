package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.TipoExecucaoEscala;
import com.example.ms_escalas.Escalas.service.TipoExecucaoEscalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("tipo-execucao-escala")
public class TipoExecucaoEscalaController {


    @Autowired
    private TipoExecucaoEscalaService tipoExecucaoEscalaService;

    @PostMapping
    public ResponseEntity<?> criarTipoExecucaoEscala(@RequestBody TipoExecucaoEscala tipoExecucaoEscalaInput) {
        TipoExecucaoEscala tipoExecucaoEscala = tipoExecucaoEscalaService.salvaTipoExecucaoEscala(tipoExecucaoEscalaInput);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/tipo-escala/{id}")
                .buildAndExpand(tipoExecucaoEscala.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoExecucaoEscala> buscarPeloId(@PathVariable("id") Long id) {
        TipoExecucaoEscala tipoExecucaoEscala = tipoExecucaoEscalaService.buscarPorId(id);
        return ResponseEntity.ok().body(tipoExecucaoEscala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoExecucaoEscala> atualizaTipoExecucaoEscala(
            @PathVariable("id") Long id,
            @RequestBody TipoExecucaoEscala tipoExecucaoEscalaInput) {
        TipoExecucaoEscala tipoExecucaoEscala = tipoExecucaoEscalaService.atualizar(id, tipoExecucaoEscalaInput);
        return ResponseEntity.ok().body(tipoExecucaoEscala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaTipoExecucaoEscala(@PathVariable("id") Long id) {
        tipoExecucaoEscalaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
