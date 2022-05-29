package com.jadson.api.bookstore.dtos;

import com.jadson.api.bookstore.dominio.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO {

    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO(Categoria categoria) {
        super();
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
