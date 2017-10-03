package com.intralacos.service.dominio.autenticacao;

import com.intralacos.service.model.EntUsuario;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Usuario {

        private Long cpf;

        private String nome;

        private Date dataNascimento;

        private String email;

        private Long celular;

        private String endereco;

        private String nomeDoutor;

        private Character novato;

        private String observacao;

        private String sexo;

        private String token;

        public Usuario(EntUsuario usuario, String token) {
                this.cpf = usuario.getCpf();
                this.nome = usuario.getNome();
                this.dataNascimento = usuario.getDataNascimento();
                this.email = usuario.getEmail();
                this.celular = usuario.getCelular();
                this.endereco = usuario.getEndereco();
                this.nomeDoutor = usuario.getNomeDoutor();
                this.novato = usuario.getNovato();
                this.observacao = usuario.getObservacao();
                this.sexo = usuario.getSexo();
                this.token = token;
        }
}
