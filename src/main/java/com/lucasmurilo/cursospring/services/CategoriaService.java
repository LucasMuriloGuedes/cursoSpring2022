package com.lucasmurilo.cursospring.services;

import com.lucasmurilo.cursospring.domain.Categoria;
import com.lucasmurilo.cursospring.repository.CategoriaRepository;
import com.lucasmurilo.cursospring.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id){
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", da classe: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll(){
        List<Categoria> list = repository.findAll();
        return list;
    }

    public Categoria insert(Categoria obj){
        Categoria newObj = new Categoria();
        if(obj.getId() == null){
             newObj = obj;
        }
        return newObj;
    }
}
