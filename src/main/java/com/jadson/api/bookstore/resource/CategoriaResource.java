package com.jadson.api.bookstore.resource;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.dtos.CategoriaDTO;
import com.jadson.api.bookstore.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria obj =service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<CategoriaDTO> dtos = service.findAllCategoriaDTO();
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj) {
        obj = service.create(obj);
        URI uri = createURI(obj);
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO dto) {
        Categoria newObj = service.update(id, dto);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }

    @DeleteMapping(value= "{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private URI createURI(Categoria obj) {
        return  ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
    }

}
