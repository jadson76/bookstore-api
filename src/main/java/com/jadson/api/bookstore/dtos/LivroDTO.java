package com.jadson.api.bookstore.dtos;

import com.jadson.api.bookstore.dominio.Livro;
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
public class LivroDTO {
    private Integer id;
    @NotEmpty(message = "Campo titulo é requerido.")
    @Length(min = 3, max = 100, message = "O titulo nome deve ter entre 3 e 50 caracteres.")
    private String titulo;
    @NotEmpty(message = "Campo nome do autor é requerido.")
    @Length(min = 3, max = 100, message = "O campo nome do autor deve ter entre 3 e 50 caracteres.")
    private String nomeAutor;
    @NotEmpty(message = "Campo texto é requerido.")
    @Length(min = 10, max = 2000000, message = "O campo texto deve ter entre 10 e 2.000.000 caracteres.")
    private String texto;

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.nomeAutor = livro.getNomeAutor();
        this.texto = livro.getTexto();
    }
}
