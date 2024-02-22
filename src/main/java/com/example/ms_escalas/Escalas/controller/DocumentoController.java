package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        String path = documentoService.uploadFile(file);
        return ResponseEntity.ok().body(path);
    }
}
