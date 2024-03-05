package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.TipoEscala;
import com.example.ms_escalas.Escalas.repository.TipoEscalaRepository;
import com.example.ms_escalas.Escalas.repository.TipoExecucaoEscalaRepository;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEscalaService {


    @Autowired
    private TipoEscalaRepository tipoEscalaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TipoEscala salvaTipoEscala(TipoEscala tipoEscalaInput) {
        TipoEscala tipoEscala = tipoEscalaRepository.save(tipoEscalaInput);
        return tipoEscala;
    }

    public TipoEscala buscarPorId(Long id) {
        TipoEscala tipoEscala = tipoEscalaRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Tipo Escala não encontrada com o id: " + id));
        return tipoEscala;
    }

    public TipoEscala atualizar(Long id, TipoEscala tipoEscalaInput) {
        TipoEscala tipoEscala = buscarPorId(id);
        modelMapper.map(tipoEscalaInput, tipoEscala);
        tipoEscala = tipoEscalaRepository.save(tipoEscala);
        return tipoEscala;
    }

    public void delete(Long id) {
        buscarPorId(id);
        tipoEscalaRepository.deleteById(id);
    }
    
}
