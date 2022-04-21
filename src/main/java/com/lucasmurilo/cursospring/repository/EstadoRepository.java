package com.lucasmurilo.cursospring.repository;

import com.lucasmurilo.cursospring.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
