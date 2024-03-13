package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.FrequenciaTrabalho;
import com.example.ms_escalas.Escalas.model.TipoEscala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequenciaTrabalhoRepository extends JpaRepository<FrequenciaTrabalho, Long> {

}
