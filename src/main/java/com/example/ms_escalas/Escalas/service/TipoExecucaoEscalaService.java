package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.TipoExecucaoEscala;
import com.example.ms_escalas.Escalas.repository.RegimeJornadaTrabalhoRepository;
import com.example.ms_escalas.Escalas.repository.TipoExecucaoEscalaRepository;
import com.example.ms_escalas.Escalas.repository.TipoExecucaoEscalaRepository;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoExecucaoEscalaService {


    @Autowired
    private TipoExecucaoEscalaRepository tipoExecucaoEscalaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TipoExecucaoEscala salvaTipoExecucaoEscala(TipoExecucaoEscala tipoExecucaoEscalaInput) {
        TipoExecucaoEscala tipoExecucaoEscala = tipoExecucaoEscalaRepository.save(tipoExecucaoEscalaInput);
        return tipoExecucaoEscala;
    }

    public TipoExecucaoEscala buscarPorId(Long id) {
        TipoExecucaoEscala tipoExecucaoEscala = tipoExecucaoEscalaRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Tipo Execucao Escala não encontrada com o id: " + id));
        return tipoExecucaoEscala;
    }

    public TipoExecucaoEscala atualizar(Long id, TipoExecucaoEscala tipoExecucaoEscalaInput) {
        TipoExecucaoEscala tipoExecucaoEscala = buscarPorId(id);
        modelMapper.map(tipoExecucaoEscalaInput, tipoExecucaoEscala);
        tipoExecucaoEscala = tipoExecucaoEscalaRepository.save(tipoExecucaoEscala);
        return tipoExecucaoEscala;
    }

    public void delete(Long id) {
        buscarPorId(id);
        tipoExecucaoEscalaRepository.deleteById(id);
    }

}
