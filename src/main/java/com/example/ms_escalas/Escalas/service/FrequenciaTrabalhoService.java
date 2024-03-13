package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.FrequenciaTrabalho;
import com.example.ms_escalas.Escalas.model.dto.FrequenciaTrabalhoInputDTO;
import com.example.ms_escalas.Escalas.repository.FrequenciaTrabalhoRepository;
import com.example.ms_escalas.Escalas.repository.FrequenciaTrabalhoRepository;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrequenciaTrabalhoService {

    @Autowired
    private FrequenciaTrabalhoRepository frequenciaTrabalhoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public FrequenciaTrabalho salvaFrequenciaTrabalho(FrequenciaTrabalhoInputDTO frequenciaTrabalhoInput) {
        FrequenciaTrabalho frequenciaTrabalho = modelMapper.map(frequenciaTrabalhoInput, FrequenciaTrabalho.class);
        frequenciaTrabalho = frequenciaTrabalhoRepository.save(frequenciaTrabalho);
        return frequenciaTrabalho;
    }

    public FrequenciaTrabalho buscarPorId(Long id) {
        FrequenciaTrabalho frequenciaTrabalho = frequenciaTrabalhoRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Carga Horaria Semanal não encontrada com o id: " + id));
        return frequenciaTrabalho;
    }

    public FrequenciaTrabalho atualizar(Long id, FrequenciaTrabalho frequenciaTrabalhoInput) {
        FrequenciaTrabalho frequenciaTrabalho = buscarPorId(id);
        modelMapper.map(frequenciaTrabalhoInput, frequenciaTrabalho);
        frequenciaTrabalho = frequenciaTrabalhoRepository.save(frequenciaTrabalho);
        return frequenciaTrabalho;
    }

    public void delete(Long id) {
        buscarPorId(id);
        frequenciaTrabalhoRepository.deleteById(id);
    }
}
