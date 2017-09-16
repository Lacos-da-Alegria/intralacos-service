package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EntSexo {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SEXO_ID")
    private Long sexoId;

    @Column(name = "DESCR")
    private String descr;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CPF")
    private EntUsuario usuario;
}
