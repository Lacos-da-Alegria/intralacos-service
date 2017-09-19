package com.intralacos.service.repository;

import com.intralacos.service.model.EntEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Enderecos extends JpaRepository<EntEndereco, Long> {
}
