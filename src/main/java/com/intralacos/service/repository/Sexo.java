package com.intralacos.service.repository;

import com.intralacos.service.model.EntSexo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Sexo extends JpaRepository<EntSexo, Long> {
}
