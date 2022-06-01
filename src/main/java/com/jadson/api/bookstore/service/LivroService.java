package com.jadson.api.bookstore.service;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.dominio.Livro;
import com.jadson.api.bookstore.dtos.LivroDTO;
import com.jadson.api.bookstore.exceptions.ObjectNotFoundException;
import com.jadson.api.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado."));
    }

    public List<LivroDTO> findAllLivroDTO(Integer idCat) {
        categoriaService.findById(idCat);
        List<Livro> list = findAllByCategoria(idCat);
        return list.stream()
                .map(LivroDTO::new).collect(Collectors.toList());
    }

    private List<Livro> findAllByCategoria(Integer idCat) {
        return repository.findAllByCategoria(idCat);
    }

    public Livro create(Integer idCat, Livro obj) {
        Categoria cat = categoriaService.findById(idCat);
        obj.setId(null);
        obj.setCategoria(cat);
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
        repository.deleteById(id);
    }
}
