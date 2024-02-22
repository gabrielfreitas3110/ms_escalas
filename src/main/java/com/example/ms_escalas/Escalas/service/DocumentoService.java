package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.Documento;
import com.example.ms_escalas.Escalas.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Value("${directory}")
    private String directory;

    public String uploadFile(MultipartFile file) {
        String filename = file.getOriginalFilename();
        Path filePath = Paths.get(directory, filename);

        try {
            byte[] bytes = file.getBytes();
            Files.write(filePath, bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String absolutPath = filePath.toAbsolutePath().toString();

        Documento documento = new Documento();
        documento.setPath(absolutPath);
        documentoRepository.save(documento);

        return absolutPath;
  }

}
