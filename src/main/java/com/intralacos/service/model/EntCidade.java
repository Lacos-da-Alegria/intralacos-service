package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class EntCidade {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CIDADE_ID")
    private Long enderecoId;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO")
    private EntEndereco endereco;

    @ManyToOne
    @JoinColumn(name = "UF")
    private EntUf uf;
}
