package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.RegimeJornadaTrabalho;
import com.example.ms_escalas.Escalas.model.TipoExecucaoEscala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoExecucaoEscalaRepository extends JpaRepository<TipoExecucaoEscala, Long> {

}
