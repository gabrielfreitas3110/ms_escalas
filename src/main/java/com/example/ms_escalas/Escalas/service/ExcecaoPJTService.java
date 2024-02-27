package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.Documento;
import com.example.ms_escalas.Escalas.model.ExcecaoParametroJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.ExcecaoPJTInputDTO;
import com.example.ms_escalas.Escalas.model.dto.ExcecaoPJTOutputDTO;
import com.example.ms_escalas.Escalas.repository.ExcecaoPJTRepository;
import com.example.ms_escalas.Escalas.service.exception.BadRequestException;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                throw new BadRequestException("Os campos Data início, Data Fim e Horário Fim Execução são obrigatórios.");
            }
        }

        ExcecaoParametroJornadaTrabalho excecao = modelMapper.map(excecaoPJTInputDTO, ExcecaoParametroJornadaTrabalho.class);

        Documento documento = documentoService.getById(excecaoPJTInputDTO.getDocumento());
        if(Objects.nonNull(documento.getExcecaoPJT())) {
            throw new BadRequestException("O documento já está vinculado a  uma Exceção.");
        }
        excecao.setDocumento(documento);

        excecao = excecaoPJTRepository.save(excecao);
        return excecao;
    }

    public ExcecaoPJTOutputDTO getExcecaoById(Long id) {
        ExcecaoParametroJornadaTrabalho excecao = excecaoPJTRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Exceção não encontrada. Id: " + id));
        ExcecaoPJTOutputDTO excecaoOutput = modelMapper.map(excecao, ExcecaoPJTOutputDTO.class);
        return excecaoOutput;
    }
}
