package com.jadson.api.bookstore.resource;

import com.jadson.api.bookstore.dominio.Livro;
import com.jadson.api.bookstore.dtos.LivroDTO;
import com.jadson.api.bookstore.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
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
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer idCat) {
        List<LivroDTO> dtos = service.findAllLivroDTO(idCat);
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer idCat,
                                        @Valid @RequestBody Livro obj) {
        obj = service.create(idCat, obj);
        URI uri = createURI(obj);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Integer id, @Valid @RequestBody LivroDTO dto) {
        Livro newObj = service.update(id, dto);
        return ResponseEntity.ok().body(new LivroDTO(newObj));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI createURI(Livro obj) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/livros/{id}").buildAndExpand(obj.getId()).toUri();
    }
}
