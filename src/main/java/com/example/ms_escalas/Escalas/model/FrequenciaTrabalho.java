package com.example.ms_escalas.Escalas.model;

import com.example.ms_escalas.Escalas.model.enums.UnidadeTempoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FrequenciaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidadeExecucao;
    private UnidadeTempoEnum unidadeTempoEnum;
}
