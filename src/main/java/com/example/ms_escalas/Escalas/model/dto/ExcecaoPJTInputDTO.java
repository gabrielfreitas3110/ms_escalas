package com.example.ms_escalas.Escalas.model.dto;

import com.example.ms_escalas.Escalas.model.Documento;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
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
public class ExcecaoPJTInputDTO {

    @NotNull(message = "Id da Unidade é obrigatório.")
    private Long unidade;

    @NotNull(message = "Id da Setor é obrigatório.")
    private Long setor;

    @NotNull(message = "Servidor Masp é obrigatório.")
    private String servidorMasp;
    private String categoriaProfissional;

    @NotNull(message = "Tempo Determinado é obrigatório.")
    private Boolean isTempoDeterminado;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horarioFimExecucao;
    private String numeroSEI;

    @NotNull(message = "Justificativa é obrigatório.")
    private String justificativa;

    @NotNull(message = "Documento é obrigatório.")
    private Long documento;
}
