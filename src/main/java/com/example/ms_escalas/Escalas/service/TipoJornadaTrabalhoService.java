package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.TipoJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.TipoJornadaTrabalhoInputDTO;
import com.example.ms_escalas.Escalas.repository.TipoJornadaTrabalhoRepository;
import com.example.ms_escalas.Escalas.repository.TipoJornadaTrabalhoRepository;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoJornadaTrabalhoService {

    @Autowired
    private TipoJornadaTrabalhoRepository tipoJornadaTrabalhoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TipoJornadaTrabalho salvaTipoJornadaTrabalho(TipoJornadaTrabalhoInputDTO tipoJornadaTrabalhoInput) {

        TipoJornadaTrabalho tipoJornadaTrabalho = modelMapper.map(tipoJornadaTrabalhoInput, TipoJornadaTrabalho.class);
        tipoJornadaTrabalho = tipoJornadaTrabalhoRepository.save(tipoJornadaTrabalho);
        return tipoJornadaTrabalho;
    }

    public TipoJornadaTrabalho buscarPorId(Long id) {
        TipoJornadaTrabalho tipoJornadaTrabalho = tipoJornadaTrabalhoRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Carga Horaria Semanal não encontrada com o id: " + id));
        return tipoJornadaTrabalho;
    }

    public TipoJornadaTrabalho atualizar(Long id, TipoJornadaTrabalho tipoJornadaTrabalhoInput) {
        TipoJornadaTrabalho tipoJornadaTrabalho = buscarPorId(id);
        modelMapper.map(tipoJornadaTrabalhoInput, tipoJornadaTrabalho);
        tipoJornadaTrabalho = tipoJornadaTrabalhoRepository.save(tipoJornadaTrabalho);
        return tipoJornadaTrabalho;
    }

    public void delete(Long id) {
        buscarPorId(id);
        tipoJornadaTrabalhoRepository.deleteById(id);
    }
}
