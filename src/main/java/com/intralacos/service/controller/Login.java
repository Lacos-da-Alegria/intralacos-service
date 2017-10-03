package com.intralacos.service.controller;

import com.intralacos.service.dominio.autenticacao.AutenticacaoService;
import com.intralacos.service.dominio.autenticacao.UsuarioAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public @ResponseBody
    String login(@RequestBody UsuarioAutenticacao usuario) {
        String token = this.autenticacaoService.autenticar(usuario);

        return token;
    }
}
