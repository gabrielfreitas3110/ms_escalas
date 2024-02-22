package com.example.ms_escalas.Escalas.repository;

import com.example.ms_escalas.Escalas.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
