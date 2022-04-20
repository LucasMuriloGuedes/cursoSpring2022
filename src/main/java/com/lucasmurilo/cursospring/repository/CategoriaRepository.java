package com.lucasmurilo.cursospring.repository;

import com.lucasmurilo.cursospring.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
