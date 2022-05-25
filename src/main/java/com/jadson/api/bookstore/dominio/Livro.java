package com.jadson.api.bookstore.dominio;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"titulo","nomeAutor","texto","categoria"})
public class Livro {

    private Integer id;
    private String titulo;
    private String nomeAutor;
    private String texto;

    private Categoria categoria;
}
