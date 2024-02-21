package com.example.ms_escalas.Escalas.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UnidadeTempoEnum {
    DIAS(0, "Dias"),
    HORAS(1, "Horas");

    private Integer id;
    private String descricao;

}
