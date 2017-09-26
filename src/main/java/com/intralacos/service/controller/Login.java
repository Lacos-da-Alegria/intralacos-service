package com.intralacos.service.controller;

import com.intralacos.service.autenticacao.AutenticacaoService;
import com.intralacos.service.autenticacao.UsuarioAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public @ResponseBody
    UsuarioAutenticacao login(@RequestBody UsuarioAutenticacao usuario) {
        UsuarioAutenticacao token = this.autenticacaoService.autenticar(usuario);

        return token;
    }
}
