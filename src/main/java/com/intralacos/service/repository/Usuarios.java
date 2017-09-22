package com.intralacos.service.repository;

import com.intralacos.service.model.EntUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuarios  extends JpaRepository<EntUsuario, Long> {
}
