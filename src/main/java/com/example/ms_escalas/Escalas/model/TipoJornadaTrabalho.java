package com.example.ms_escalas.Escalas.model;

import com.example.ms_escalas.Escalas.model.enums.TipoCargaHorariaEnum;
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
public class TipoJornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime horarioDiario;
    private String descricao;
    private TipoCargaHorariaEnum tipoCargaHorariaEnum;
    private Integer vezesPorSemana;
    private Boolean isPlantao;
}
