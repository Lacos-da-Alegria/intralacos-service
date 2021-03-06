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

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Id
    @Column(name = "CPF")
    private Long cpf;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "EMAIL")
    private String email;

    // Faremos o tratamento do DDD no front-end (61) 99999-9999 -> 619999999999
    @Column(name = "CELULAR")
    private Long celular;

    @OneToOne
    @JoinColumn(name = "ENDERECO", nullable = false, updatable = true)
    private EntEndereco endereco;

    @ManyToOne
    @JoinColumn(name = "PERFIL", nullable = false, updatable = true)
    private EntPerfil perfil;

    @ManyToOne
    @JoinColumn(name = "PRIMEIRA_ATIVIDADE", nullable = false, updatable = true)
    private EntAtividade primeiraAtividade;

    @ManyToOne
    @JoinColumn(name = "SEXO", nullable = false, updatable = true)
    private EntSexo sexo;

    @ManyToOne
    @JoinColumn(name = "COMO_CONHECEU", nullable = false, updatable = true)
    private EntComoConheceu comoConheceu;
}
