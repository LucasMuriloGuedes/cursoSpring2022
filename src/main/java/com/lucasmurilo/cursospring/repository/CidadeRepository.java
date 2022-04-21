package com.lucasmurilo.cursospring.repository;

import com.lucasmurilo.cursospring.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
