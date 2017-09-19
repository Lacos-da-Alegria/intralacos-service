package com.intralacos.service.repository;

import com.intralacos.service.model.EntCidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cidades extends JpaRepository<EntCidade, Long> {
}
