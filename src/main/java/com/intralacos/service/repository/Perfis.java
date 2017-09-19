package com.intralacos.service.repository;

import com.intralacos.service.model.EntPerfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Perfis extends JpaRepository<EntPerfil, Long> {
}
