package com.example.ms_escalas.Escalas.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public enum ExtensoesEnum {
    PNG(0, "png"),
    PDF(1, "pdf"),
    DOCX(2, "docx");

    private Integer id;
    private String descricao;

    public static List<String> getDescricoes() {
        return Arrays.stream(ExtensoesEnum.values())
                .map(ExtensoesEnum::getDescricao)
                .toList();
    }
}
