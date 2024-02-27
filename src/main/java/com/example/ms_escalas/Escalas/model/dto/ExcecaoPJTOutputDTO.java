package com.example.ms_escalas.Escalas.model.dto;

import com.example.ms_escalas.Escalas.model.Documento;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExcecaoPJTOutputDTO {

    private Long id;
    private Long unidade;
    private Long setor;
    private String servidorMasp;
    private String categoriaProfissional;
    private Boolean isTempoDeterminado;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horarioFimExecucao;
    private String numeroSEI;
    private String justificativa;
    private DocumentoOutputDTO documento;
}
