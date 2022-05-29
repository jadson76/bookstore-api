package com.jadson.api.bookstore.service;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.dtos.CategoriaDTO;
import com.jadson.api.bookstore.exceptions.ObjectNotFoundException;
import com.jadson.api.bookstore.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO dto) {
        Categoria obj = findById(id);
        obj.setNome(dto.getNome());
        obj.setDescricao(dto.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException ex) {
            throw new com.jadson.api.bookstore
                    .exceptions
                    .DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
        }
    }
}
