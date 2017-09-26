package com.intralacos.service.autenticacao;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAutenticacao {

    private String email;
    private String senha;
}
