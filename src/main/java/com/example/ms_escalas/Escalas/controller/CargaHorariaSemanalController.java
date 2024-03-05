package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.CargaHorariaSemanal;
import com.example.ms_escalas.Escalas.model.Documento;
import com.example.ms_escalas.Escalas.service.CargaHorariaSemanalService;
import com.example.ms_escalas.Escalas.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("carga-horaria-semanal")
public class CargaHorariaSemanalController {

    @Autowired
    private CargaHorariaSemanalService cargaHorariaSemanalService;

    @PostMapping
    public ResponseEntity<?> criarCargaHoraria(@RequestBody CargaHorariaSemanal cargaHorariaSemanalInput) {
        CargaHorariaSemanal cargaHorariaSemanal = cargaHorariaSemanalService.salvaCargaHoraria(cargaHorariaSemanalInput);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/carga-horaria-semanal/{id}")
                .buildAndExpand(cargaHorariaSemanal.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargaHorariaSemanal> buscarPeloId(@PathVariable("id") Long id) {
        CargaHorariaSemanal cargaHorariaSemanal = cargaHorariaSemanalService.buscarPorId(id);
        return ResponseEntity.ok().body(cargaHorariaSemanal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargaHorariaSemanal> atualizaCargaHoraria(
            @PathVariable("id") Long id,
            @RequestBody CargaHorariaSemanal cargaHorariaSemanalInput) {
        CargaHorariaSemanal cargaHorariaSemanal = cargaHorariaSemanalService.atualizar(id, cargaHorariaSemanalInput);
        return ResponseEntity.ok().body(cargaHorariaSemanal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaCargaHoraria(@PathVariable("id") Long id) {
        cargaHorariaSemanalService.delete(id);
        return ResponseEntity.ok().build();
    }
}
