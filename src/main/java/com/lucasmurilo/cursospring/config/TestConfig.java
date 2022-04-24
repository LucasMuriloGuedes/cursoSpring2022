package com.lucasmurilo.cursospring.config;

import com.lucasmurilo.cursospring.domain.*;
import com.lucasmurilo.cursospring.domain.enums.TipoCliente;
import com.lucasmurilo.cursospring.repository.*;
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

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "3535154124", TipoCliente.PESSOA_FISICA);
        cli1.getTelefones().addAll(Arrays.asList("65981505851", "981133307"));

        Endereco end1 = new Endereco(null, "Rua Flores", "300", "ap303", "Jardim", "35353535", cli1, cid1);
        Endereco end2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "Centro", "015424222", cli1, cid2);
        cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(end1, end2));
    }
}
