package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.Documento;
import com.example.ms_escalas.Escalas.model.ExcecaoParametroJornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcecaoPJTRepository extends JpaRepository<ExcecaoParametroJornadaTrabalho, Long> {

}
