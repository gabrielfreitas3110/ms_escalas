package com.example.ms_escalas.Escalas.model;

import com.example.ms_escalas.Escalas.model.enums.HabilitadoEnum;
import com.example.ms_escalas.Escalas.model.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParametroJornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime cargaHorariaDiaria;
    private Boolean isTrocaPlantao;
    private LocalDate dataInicio;
    private LocalTime horarioInicio;
    private LocalTime horarioFinal;
    private LocalTime intervalo;
    private LocalTime tolerancia;
    private String comportamentoApuracao;
    private StatusEnum statusEnum;
    private HabilitadoEnum habilitadoEnum;

    @OneToMany
    @JoinColumn(name = "parametro_jornada_trabalho_id")
    private List<ExcecaoParametroJornadaTrabalho> excecoesParametroJornadaTrabalho;

    @OneToOne
    @JoinColumn(name = "carga_horaria_semanal_id")
    private CargaHorariaSemanal cargaHorariaSemanal;

    @OneToOne
    @JoinColumn(name = "frequencia_trabalho_id")
    private FrequenciaTrabalho frequenciaTrabalho;

    @OneToOne
    @JoinColumn(name = "regime_jornada_trabalho_id")
    private RegimeJornadaTrabalho regimeJornadaTrabalho;

    @OneToOne
    @JoinColumn(name = "tipo_escala_id")
    private TipoEscala tipoEscala;

    @OneToOne
    @JoinColumn(name = "tipo_execucao_escala_id")
    private TipoExecucaoEscala tipoExecucaoEscala;

    @OneToOne
    @JoinColumn(name = "tipo_jornada_trabalho_id")
    private TipoJornadaTrabalho tipoJornadaTrabalho;
}
