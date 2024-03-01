package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.Documento;
import com.example.ms_escalas.Escalas.model.enums.ExtensoesEnum;
import com.example.ms_escalas.Escalas.repository.DocumentoRepository;
import com.example.ms_escalas.Escalas.service.exception.BadRequestException;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Value("${directory}")
    private String directory;

    public Documento uploadFile(MultipartFile file) {
        String filename = file.getOriginalFilename();

        String extensao = filename.substring(filename.lastIndexOf(".") + 1);

        List<String> extensoesPermitidas = ExtensoesEnum.getDescricoes();

        if(!extensoesPermitidas.contains(extensao)) {
            throw new BadRequestException("Extensão não permitida.");
        }
        Path directoryPath = Paths.get(directory);
        if(!Files.exists(directoryPath) || !Files.isDirectory(directoryPath)) {
            File direcotryFile = new File(directory);
            direcotryFile.mkdirs();
        }
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
        documento = documentoRepository.save(documento);

        return documento;
  }

    public Resource getFile(Long id) {
        Documento documento = getById(id);

        Path filePath = Paths.get(documento.getPath());
        Resource resource;

        try {
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return  resource;
    }

    public Documento getById(Long id) {
        return documentoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado. Id: " + id));
    }
}
