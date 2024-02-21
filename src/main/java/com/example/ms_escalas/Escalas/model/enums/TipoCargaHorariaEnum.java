package com.example.ms_escalas.Escalas.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoCargaHorariaEnum {
    DIARIA(0, "Diária"),
    SEMANAL(1, "Semanal");

    private Integer id;
    private String descricao;

}
