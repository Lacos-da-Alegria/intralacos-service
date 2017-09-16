package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EntAtividade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ATIVIDADE_ID")
    private Long atividadeId;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "SIGLA")
    private String sigla;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "DHORA")
    private String diaEHoraDaVisita;

    @Column(name = "LOCAL_PREPARO")
    private String localPreparo;

    @Column(name = "NUM_VOLUNTARIO")
    private Long numVoluntarios;

    @OneToOne
    @JoinColumn(name = "ENDERECO", nullable = false, updatable = true)
    private EntEndereco endereco;

}
