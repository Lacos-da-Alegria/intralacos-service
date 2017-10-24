package com.intralacos.service.controller;

import com.intralacos.service.model.usuario.UsuarioModel;
import com.intralacos.service.repository.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/")
public class HelloWorld {

    @Autowired
    private Usuarios usuarios;

    @GetMapping
    public @ResponseBody
    UsuarioModel helloWorld() throws UnsupportedEncodingException {
        UsuarioModel usuario = this.usuarios.findOne(Long.parseLong("12914972261"));

        return usuario;
    }
}
