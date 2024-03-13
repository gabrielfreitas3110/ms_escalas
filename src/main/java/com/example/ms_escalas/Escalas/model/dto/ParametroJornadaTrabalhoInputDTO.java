package com.example.ms_escalas.Escalas.model.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParametroJornadaTrabalhoInputDTO {

    private LocalTime cargaHorariaDiaria;
    private Boolean isTrocaPlantao;
    private LocalDate dataInicio;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private LocalTime intervalo;
    private LocalTime tolerancia;
    private String comportamentoApuracao;
    private Integer statusEnum = 1;
    private Integer habilitadoEnum = 1;

    @NotNull(message = "O campo Carga Horaria Semanal é obrigatório.")
    private Long cargaHorariaSemanalId;
    @NotNull(message = "O campo Regime Jornada Trabalho é obrigatório.")
    private Long regimeJornadaTrabalhoId;
    @NotNull(message = "O campo Tipo Execução Escala é obrigatório.")
    private Long tipoExecucaoEscalaId;
    @NotNull(message = "O campo Tipo Escala é obrigatório.")
    private Long tipoEscalaId;
    @NotNull(message = "O campo Frequência Trabalho é obrigatório.")
    private Long frequenciaTrabalhoId;
    @NotNull(message = "O campo Tipo Jornada Trabalho é obrigatório.")
    private Long tipoJornadaTrabalhoId;

    @NotNull(message = "O campo Exceção Jornada Trabalho é obrigatório.")
    @NotEmpty(message = "Pelo menos uma Exceção Jornada Trabalho é obrigatória.")
    private List<Long> exccecaoJornadaTrabalhoId;


}
