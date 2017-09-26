package com.intralacos.service.autenticacao;

import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    public UsuarioAutenticacao autenticar(UsuarioAutenticacao usuario) {
        return usuario;
    }
}
