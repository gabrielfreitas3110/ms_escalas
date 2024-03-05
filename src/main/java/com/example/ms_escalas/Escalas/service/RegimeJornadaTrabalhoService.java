package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.RegimeJornadaTrabalho;
import com.example.ms_escalas.Escalas.repository.RegimeJornadaTrabalhoRepository;
import com.example.ms_escalas.Escalas.repository.RegimeJornadaTrabalhoRepository;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegimeJornadaTrabalhoService {


    @Autowired
    private RegimeJornadaTrabalhoRepository regimeJornadaTrabalhoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RegimeJornadaTrabalho salvaRegimeJornadaTrabalho(RegimeJornadaTrabalho regimeJornadaTrabalhoInput) {
        RegimeJornadaTrabalho regimeJornadaTrabalho = regimeJornadaTrabalhoRepository.save(regimeJornadaTrabalhoInput);
        return regimeJornadaTrabalho;
    }

    public RegimeJornadaTrabalho buscarPorId(Long id) {
        RegimeJornadaTrabalho regimeJornadaTrabalho = regimeJornadaTrabalhoRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Regime Jornada Trabalho não encontrada com o id: " + id));
        return regimeJornadaTrabalho;
    }

    public RegimeJornadaTrabalho atualizar(Long id, RegimeJornadaTrabalho regimeJornadaTrabalhoInput) {
        RegimeJornadaTrabalho regimeJornadaTrabalho = buscarPorId(id);
        modelMapper.map(regimeJornadaTrabalhoInput, regimeJornadaTrabalho);
        regimeJornadaTrabalho = regimeJornadaTrabalhoRepository.save(regimeJornadaTrabalho);
        return regimeJornadaTrabalho;
    }

    public void delete(Long id) {
        buscarPorId(id);
        regimeJornadaTrabalhoRepository.deleteById(id);
    }
}
