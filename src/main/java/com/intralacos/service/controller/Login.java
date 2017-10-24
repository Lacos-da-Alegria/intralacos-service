package com.intralacos.service.controller;

import com.intralacos.service.service.autenticacao.AutenticacaoService;
import com.intralacos.service.model.usuario.UsuarioLogadoModel;
import com.intralacos.service.model.usuario.UsuarioAutenticacaoModel;
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
    ResponseEntity<UsuarioLogadoModel> login(@RequestBody UsuarioAutenticacaoModel usuario) throws NotFoundException {
        UsuarioLogadoModel token = this.autenticacaoService.autenticar(usuario);

        if(token != null) {
            return new ResponseEntity<UsuarioLogadoModel>(token, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<UsuarioLogadoModel>(token, HttpStatus.NOT_FOUND);
        }
    }
}
