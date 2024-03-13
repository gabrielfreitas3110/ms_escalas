package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.FrequenciaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.FrequenciaTrabalhoInputDTO;
import com.example.ms_escalas.Escalas.service.FrequenciaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequestMapping("frequencia-trabalho")
@RestController
public class FrequenciaTrabalhoController {

    @Autowired
    private FrequenciaTrabalhoService frequenciaTrabalhoService;

    @PostMapping
    public ResponseEntity<?> criarFrequenciaTrabalho(@RequestBody FrequenciaTrabalhoInputDTO frequenciaTrabalhoInputDTO) {
        FrequenciaTrabalho FrequenciaTrabalho = frequenciaTrabalhoService.salvaFrequenciaTrabalho(frequenciaTrabalhoInputDTO);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/carga-horaria-/{id}")
                .buildAndExpand(FrequenciaTrabalho.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FrequenciaTrabalho> buscarPeloId(@PathVariable("id") Long id) {
        FrequenciaTrabalho FrequenciaTrabalho = frequenciaTrabalhoService.buscarPorId(id);
        return ResponseEntity.ok().body(FrequenciaTrabalho);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FrequenciaTrabalho> atualizaFrequenciaTrabalho(
            @PathVariable("id") Long id,
            @RequestBody FrequenciaTrabalho FrequenciaTrabalhoInput) {
        FrequenciaTrabalho FrequenciaTrabalho = frequenciaTrabalhoService.atualizar(id, FrequenciaTrabalhoInput);
        return ResponseEntity.ok().body(FrequenciaTrabalho);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaFrequenciaTrabalho(@PathVariable("id") Long id) {
        frequenciaTrabalhoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
