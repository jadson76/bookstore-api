package com.jadson.api.bookstore.dominio;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = {"nome","descricao","livros"})
public class Categoria {

    private Integer id;
    private String nome;
    private String descricao;
    private List<Livro> livros;
}
