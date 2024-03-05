package com.example.ms_escalas.Escalas.service;

import com.example.ms_escalas.Escalas.model.CargaHorariaSemanal;
import com.example.ms_escalas.Escalas.repository.CargaHorariaSemanalRepository;
import com.example.ms_escalas.Escalas.service.exception.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CargaHorariaSemanalService {

    @Autowired
    private CargaHorariaSemanalRepository cargaHorariaSemanalRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CargaHorariaSemanal salvaCargaHoraria(CargaHorariaSemanal cargaHorariaSemanalInput) {
        CargaHorariaSemanal cargaHorariaSemanal = cargaHorariaSemanalRepository.save(cargaHorariaSemanalInput);
        return cargaHorariaSemanal;
    }

    public CargaHorariaSemanal buscarPorId(Long id) {
        CargaHorariaSemanal cargaHorariaSemanal = cargaHorariaSemanalRepository.findById(id)
                .orElseThrow( () -> new ObjectNotFoundException("Carga Horaria Semanal não encontrada com o id: " + id));
        return cargaHorariaSemanal;
    }

    public CargaHorariaSemanal atualizar(Long id, CargaHorariaSemanal cargaHorariaSemanalInput) {
        CargaHorariaSemanal cargaHorariaSemanal = buscarPorId(id);
        modelMapper.map(cargaHorariaSemanalInput, cargaHorariaSemanal);
        cargaHorariaSemanal = cargaHorariaSemanalRepository.save(cargaHorariaSemanal);
        return cargaHorariaSemanal;
    }

    public void delete(Long id) {
        buscarPorId(id);
        cargaHorariaSemanalRepository.deleteById(id);
    }
}
