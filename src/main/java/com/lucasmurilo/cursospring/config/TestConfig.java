package com.lucasmurilo.cursospring.config;

import com.lucasmurilo.cursospring.domain.Categoria;
import com.lucasmurilo.cursospring.domain.Cidade;
import com.lucasmurilo.cursospring.domain.Estado;
import com.lucasmurilo.cursospring.domain.Produto;
import com.lucasmurilo.cursospring.repository.CategoriaRepository;
import com.lucasmurilo.cursospring.repository.CidadeRepository;
import com.lucasmurilo.cursospring.repository.EstadoRepository;
import com.lucasmurilo.cursospring.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Escritório");
        Categoria cat2 = new Categoria(null, "Informatica");

        Produto prod1 = new Produto(null, "Computador", 2000.00);
        Produto prod2 = new Produto(null, "Impressora", 1000.00);
        Produto prod3 = new Produto(null, "Mouse", 80.00);

        cat1.getProdutos().addAll(Arrays.asList(prod1, prod2, prod3));
        cat2.getProdutos().add(prod2);

        prod1.getCategorias().add(cat1);
        prod2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        prod3.getCategorias().add(cat1);

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade cid1 = new Cidade(null, "Uberlândia", est1);
        Cidade cid2 = new Cidade(null, "São Paulo", est2);
        Cidade cid3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().add(cid1);
        est2.getCidades().addAll(Arrays.asList(cid2, cid3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(prod1, prod2, prod3));





    }
}
