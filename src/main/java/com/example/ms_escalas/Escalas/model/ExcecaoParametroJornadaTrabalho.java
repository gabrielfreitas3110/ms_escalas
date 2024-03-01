package com.example.ms_escalas.Escalas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExcecaoParametroJornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long unidade;
    private Long setor;
    private String servidorMasp;
    private String categoriaProfissional;
    private Boolean isTempoDeterminado;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horarioFimExecucao;
    private String numeroSEI;
    private String justificativa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", nullable = false)
    private Documento documento;

    @ManyToOne
    @JoinColumn(name = "parametro_jornada_trabalho_id")
    private ParametroJornadaTrabalho parametroJornadaTrabalho;

}
