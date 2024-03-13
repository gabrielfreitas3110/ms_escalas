package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.CargaHorariaSemanal;
import com.example.ms_escalas.Escalas.model.ParametroJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.ParametroJornadaTrabalhoInputDTO;
import com.example.ms_escalas.Escalas.repository.ParametroJornadaTrabalhoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametroJornadaTrabalhoService {

    @Autowired
    private ParametroJornadaTrabalhoRepository parametroJornadaTrabalhoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CargaHorariaSemanalService cargaHorariaSemanalService;

    public ParametroJornadaTrabalho criarParametro(ParametroJornadaTrabalhoInputDTO parametroJornadaTrabalhoInputDTO) {
        ParametroJornadaTrabalho parametroJornadaTrabalho = modelMapper.map(parametroJornadaTrabalhoInputDTO, ParametroJornadaTrabalho.class);

        CargaHorariaSemanal cargaHorariaSemanal = cargaHorariaSemanalService.buscarPorId(parametroJornadaTrabalhoInputDTO.getCargaHorariaSemanalId());
        parametroJornadaTrabalho.setCargaHorariaSemanal(cargaHorariaSemanal);

        parametroJornadaTrabalho = parametroJornadaTrabalhoRepository.save(parametroJornadaTrabalho);
        return parametroJornadaTrabalho;
    }
}
