package com.intralacos.service.model.usuario;

import com.intralacos.service.model.usuario.UsuarioModel;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioLogadoModel {

        private Long cpf;

        private String nome;

        private Date dataNascimento;

        private String email;

        private Long celular;

                private String endereco;

        private String nomeDoutor;

        private Boolean novato;

        private String observacao;

        private String sexo;

        private String token;

        public UsuarioLogadoModel(UsuarioModel usuario, String token) {
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
