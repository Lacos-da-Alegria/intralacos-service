package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EntPerfil {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERFIL_ID")
    private Long perfilId;

    @Column(name = "DESCR")
    private String descr;
}
