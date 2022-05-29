package com.jadson.api.bookstore.service;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.dtos.CategoriaDTO;
import com.jadson.api.bookstore.exceptions.ObjectNotFoundException;
import com.jadson.api.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException("Categoria não encontrada."));
    }

    public List<CategoriaDTO> findAllCategoriaDTO(){
        List<Categoria> list = findAll();
        return list.stream()
                .map(CategoriaDTO::new).collect(Collectors.toList());
    }

    private List<Categoria> findAll() {
        return repository.findAll();
    }
}
