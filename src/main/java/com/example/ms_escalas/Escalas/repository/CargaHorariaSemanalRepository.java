package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.CargaHorariaSemanal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargaHorariaSemanalRepository extends JpaRepository<CargaHorariaSemanal, Long> {

}
