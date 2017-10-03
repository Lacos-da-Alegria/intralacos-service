package com.intralacos.service.controller;

import com.intralacos.service.dominio.autenticacao.AutenticacaoService;
import com.intralacos.service.dominio.autenticacao.Usuario;
import com.intralacos.service.dominio.autenticacao.UsuarioAutenticacao;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class Login {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public @ResponseBody @ResponseStatus(HttpStatus.NOT_FOUND)
    ResponseEntity<Usuario> login(@RequestBody UsuarioAutenticacao usuario) throws NotFoundException {
        Usuario token = this.autenticacaoService.autenticar(usuario);

        if(token != null) {
            return new ResponseEntity<Usuario>(token, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Usuario>(token, HttpStatus.NOT_FOUND);
        }
    }
}
