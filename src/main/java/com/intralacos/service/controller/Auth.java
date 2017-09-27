package com.intralacos.service.controller;

import com.intralacos.service.autenticacao.AutenticacaoService;
import com.intralacos.service.autenticacao.UsuarioAutenticacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Auth {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @RequestMapping(value = "/auth/signin/", method = RequestMethod.POST)
    public @ResponseBody
    String login(@RequestBody UsuarioAutenticacao usuario) {
        String token = this.autenticacaoService.autenticar(usuario);

        return token;
    }
}
