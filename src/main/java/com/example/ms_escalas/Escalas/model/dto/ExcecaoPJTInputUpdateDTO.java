package com.example.ms_escalas.Escalas.model.dto;

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
public class ExcecaoPJTInputUpdateDTO {

    private String categoriaProfissional;
    private String numeroSEI;
}
