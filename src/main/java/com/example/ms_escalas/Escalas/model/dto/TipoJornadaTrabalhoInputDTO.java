package com.example.ms_escalas.Escalas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoJornadaTrabalhoInputDTO {

    private LocalTime horarioDiario;
    private String descricao;
    private Integer tipoCargaHorariaEnumId;
    private Integer vezesPorSemana;
    private Boolean isPlantao;
}
