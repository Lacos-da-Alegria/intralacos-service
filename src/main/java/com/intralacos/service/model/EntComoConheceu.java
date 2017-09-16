package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EntComoConheceu {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMO_CONHECEU_ID")
    private Long comoConheceuId;

    @Column(name = "DESCR")
    private String descr;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CPF")
    private EntUsuario usuario;

}
