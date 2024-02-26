package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.Documento;
import com.example.ms_escalas.Escalas.model.ExcecaoParametroJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.input.ExcecaoPJTInputDTO;
import com.example.ms_escalas.Escalas.model.dto.input.ExcecaoPJTOutputDTO;
import com.example.ms_escalas.Escalas.model.enums.ExtensoesEnum;
import com.example.ms_escalas.Escalas.repository.DocumentoRepository;
import com.example.ms_escalas.Escalas.repository.ExcecaoPJTRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.print.Doc;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@Service
public class ExcecaoPJTService {

    @Autowired
    private ExcecaoPJTRepository excecaoPJTRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DocumentoService documentoService;

    public ExcecaoParametroJornadaTrabalho saveExcecao(ExcecaoPJTInputDTO excecaoPJTInputDTO) {

        if(excecaoPJTInputDTO.getIsTempoDeterminado()) {
            if(Objects.isNull(excecaoPJTInputDTO.getDataInicio())  || Objects.isNull(excecaoPJTInputDTO.getDataFim()) ||
            Objects.isNull(excecaoPJTInputDTO.getHorarioFimExecucao())) {
                //TODO: Lançar exceção personalizada
                return null;
            }
        }

        ExcecaoParametroJornadaTrabalho excecao = modelMapper.map(excecaoPJTInputDTO, ExcecaoParametroJornadaTrabalho.class);

        Documento documento = documentoService.getById(excecaoPJTInputDTO.getDocumento());
        excecao.setDocumento(documento);

        excecao = excecaoPJTRepository.save(excecao);
        return excecao;
    }

    public ExcecaoPJTOutputDTO getExcecaoById(Long id) {
        //TODO: criar exceção personalizada quando o objeto não for encontrado.
        ExcecaoParametroJornadaTrabalho excecao = excecaoPJTRepository.findById(id).orElseThrow(null);
        ExcecaoPJTOutputDTO excecaoOutput = modelMapper.map(excecao, ExcecaoPJTOutputDTO.class);
        return excecaoOutput;
    }
}
