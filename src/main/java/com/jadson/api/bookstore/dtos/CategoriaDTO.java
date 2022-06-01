package com.jadson.api.bookstore.dtos;

import com.jadson.api.bookstore.dominio.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoriaDTO {

    private Integer id;
    @NotEmpty(message = "Campo nome é requerido.")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message = "Campo descrição é requerido.")
    @Length(min = 3, max = 200, message = "O campo descrição deve ter entre 3 e 200 caracteres.")
    private String descricao;

    public CategoriaDTO(Categoria categoria) {
        super();
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
