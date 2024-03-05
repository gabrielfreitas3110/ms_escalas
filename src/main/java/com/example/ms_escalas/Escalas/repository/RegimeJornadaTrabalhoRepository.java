package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.CargaHorariaSemanal;
import com.example.ms_escalas.Escalas.model.RegimeJornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimeJornadaTrabalhoRepository extends JpaRepository<RegimeJornadaTrabalho, Long> {

}
