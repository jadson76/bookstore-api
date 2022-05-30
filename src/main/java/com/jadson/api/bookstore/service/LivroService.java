package com.jadson.api.bookstore.service;

import com.jadson.api.bookstore.dominio.Livro;
import com.jadson.api.bookstore.dtos.LivroDTO;
import com.jadson.api.bookstore.exceptions.ObjectNotFoundException;
import com.jadson.api.bookstore.repository.LivroRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private LivroRepository repository;

    public Livro findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado."));
    }

    public List<LivroDTO> findAllLivroDTO() {
        List<Livro> list = findAll();
        return list.stream()
                .map(LivroDTO::new).collect(Collectors.toList());
    }

    private List<Livro> findAll() {
        return repository.findAll();
    }

    public Livro create(Livro obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Livro update(Integer id, LivroDTO dto) {
        Livro obj = findById(id);
        obj.setTitulo(dto.getTitulo());
        obj.setTexto(dto.getTexto());
        obj.setNomeAutor(dto.getNomeAutor());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException ex) {
            throw new com.jadson.api.bookstore
                    .exceptions
                    .DataIntegrityViolationException("Livro não pode ser deletado!");
        }
    }
}
