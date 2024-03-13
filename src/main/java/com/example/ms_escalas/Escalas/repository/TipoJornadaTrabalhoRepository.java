package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.TipoEscala;
import com.example.ms_escalas.Escalas.model.TipoJornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoJornadaTrabalhoRepository extends JpaRepository<TipoJornadaTrabalho, Long> {

}
