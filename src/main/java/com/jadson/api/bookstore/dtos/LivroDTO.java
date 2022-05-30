package com.jadson.api.bookstore.dtos;

import com.jadson.api.bookstore.dominio.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LivroDTO {
    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getNomeAutor();
        this.texto = livro.getTexto();
    }
}
