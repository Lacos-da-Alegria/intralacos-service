package com.intralacos.service.model.usuario;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "USUARIO")
public class UsuarioModel implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CPF", nullable = false, unique = true)
    private Long cpf;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    // Faremos o tratamento do DDD no front-end (61) 99999-9999 -> 619999999999
    @Column(name = "CELULAR")
    private Long celular;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "NOME_DOUTOR")
    private String nomeDoutor;

    @Column(name = "NOVATO")
    private Boolean novato;

    @Column(name = "OBSERVACAO")
    private String observacao;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "SEXO")
    private String sexo;

    @Column(name = "ATIVO", nullable = false)
    private boolean ativo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return ativo;
    }
}
