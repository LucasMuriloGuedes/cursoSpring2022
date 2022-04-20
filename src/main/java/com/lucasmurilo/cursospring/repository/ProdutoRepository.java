package com.lucasmurilo.cursospring.repository;

import com.lucasmurilo.cursospring.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
