package com.jadson.api.bookstore.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity()
@Table(name = "LIVRO")
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return id.equals(livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
