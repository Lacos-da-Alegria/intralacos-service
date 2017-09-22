package com.intralacos.service.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class EntUsuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "EMAIL")
    private String email;

    // Faremos o tratamento do DDD no front-end (61) 99999-9999 -> 619999999999
    @Column(name = "CELULAR")
    private Long celular;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "NOME_DOUTOR")
    private String nomeDoutor;

    @Column(name = "NOVATO")
    private Character novato;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "SEXO")
    private String sexo;
}
