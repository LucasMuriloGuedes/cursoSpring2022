package com.lucasmurilo.cursospring.repository;

import com.lucasmurilo.cursospring.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
