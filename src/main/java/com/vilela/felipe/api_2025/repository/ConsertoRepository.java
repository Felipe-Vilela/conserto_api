package com.vilela.felipe.api_2025.repository;

import com.vilela.felipe.api_2025.model.entity.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}