package com.intralacos.service.repository;

import com.intralacos.service.model.usuario.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios  extends JpaRepository<UsuarioModel, Long> {
    UsuarioModel findByEmail(String email);
}
