package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class EntEndereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ENDERECO_ID")
    private Long enderecoId;

    @Column(name = "ENDERECO")
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "CIDADE", nullable = false, updatable = true)
    private EntCidade cidade;

    @ManyToOne
    @JoinColumn(name = "UF", nullable = false, updatable = true)
    private EntUf uf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CPF")
    private EntUsuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ATIVIDADE")
    private EntAtividade atividade;

}
