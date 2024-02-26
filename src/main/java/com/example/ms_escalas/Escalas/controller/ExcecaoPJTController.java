package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.ExcecaoParametroJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.input.ExcecaoPJTInputDTO;
import com.example.ms_escalas.Escalas.model.dto.input.ExcecaoPJTOutputDTO;
import com.example.ms_escalas.Escalas.service.DocumentoService;
import com.example.ms_escalas.Escalas.service.ExcecaoPJTService;
import jakarta.validation.Valid;
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
@RequestMapping("excecao-parametro-jornada-trabalho")
public class ExcecaoPJTController {

    @Autowired
    private ExcecaoPJTService excecaoPJTService;

    @PostMapping
    public ResponseEntity<?> criarExcecao(@RequestBody @Valid ExcecaoPJTInputDTO excecaoPJTInputDTO) {
        ExcecaoParametroJornadaTrabalho excecao = excecaoPJTService.saveExcecao(excecaoPJTInputDTO);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/excecao-parametro-jornada-trabalho/{id}")
                .buildAndExpand(excecao.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<ExcecaoPJTOutputDTO> buscarPorId(@PathVariable("id") Long id) {
        ExcecaoPJTOutputDTO excecao = excecaoPJTService.getExcecaoById(id);
        return ResponseEntity.ok().body(excecao);

    }

}
