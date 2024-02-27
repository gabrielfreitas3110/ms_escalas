package com.example.ms_escalas.Escalas.controller;

import com.example.ms_escalas.Escalas.model.Documento;
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
@RequestMapping("documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {

        Documento documento = documentoService.uploadFile(file);
        URI location = UriComponentsBuilder.fromUriString("http://localhost:8080/documento/download/{id}")
                .buildAndExpand(documento.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable("id") Long id) {
        Resource resource = documentoService.getFile(id);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attchment; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

}
