package com.example.ms_escalas.Escalas.model.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum HabilitadoEnum {
    NAO(0, "Não"),
    SIM(1, "Sim");

    private Integer id;
    private String descricao;

}
