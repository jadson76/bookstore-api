package com.jadson.api.bookstore.service;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()-> new  IllegalArgumentException("Categoria não encontrada."));
    }
}
