package com.intralacos.service.repository;

import com.intralacos.service.model.EntAtividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Atividades extends JpaRepository<EntAtividade, Long> {
}
