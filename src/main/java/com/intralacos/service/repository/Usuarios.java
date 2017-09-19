package com.intralacos.service.repository;

import com.intralacos.service.model.EntUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Usuarios extends JpaRepository<EntUsuario, Long> {
}
