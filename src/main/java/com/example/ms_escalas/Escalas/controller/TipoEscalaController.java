package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.TipoEscala;
import com.example.ms_escalas.Escalas.service.TipoEscalaService;
import com.example.ms_escalas.Escalas.service.TipoExecucaoEscalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("tipo-escala")
public class TipoEscalaController {

    @Autowired
    private TipoEscalaService tipoEscalaService;

    @PostMapping
    public ResponseEntity<?> criarTipoEscala(@RequestBody TipoEscala tipoEscalaInput) {
        TipoEscala tipoEscala = tipoEscalaService.salvaTipoEscala(tipoEscalaInput);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/tipo-escala/{id}")
                .buildAndExpand(tipoEscala.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEscala> buscarPeloId(@PathVariable("id") Long id) {
        TipoEscala tipoEscala = tipoEscalaService.buscarPorId(id);
        return ResponseEntity.ok().body(tipoEscala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEscala> atualizaTipoEscala(
            @PathVariable("id") Long id,
            @RequestBody TipoEscala tipoEscalaInput) {
        TipoEscala tipoEscala = tipoEscalaService.atualizar(id, tipoEscalaInput);
        return ResponseEntity.ok().body(tipoEscala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaTipoEscala(@PathVariable("id") Long id) {
        tipoEscalaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
