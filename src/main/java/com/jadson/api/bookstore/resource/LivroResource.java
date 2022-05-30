package com.jadson.api.bookstore.resource;

import com.jadson.api.bookstore.dominio.Livro;
import com.jadson.api.bookstore.dtos.LivroDTO;
import com.jadson.api.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping()
    public ResponseEntity<List<LivroDTO>> findAll() {
        List<LivroDTO> dtos = service.findAllLivroDTO();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro obj) {
        obj = service.create(obj);
        URI uri = createURI(obj);
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @RequestBody LivroDTO dto) {
        Livro newObj = service.update(id, dto);
        return ResponseEntity.ok().body(new LivroDTO(newObj));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI createURI(Livro obj) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
    }
}
