package com.jadson.api.bookstore.service;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.dominio.Livro;
import com.jadson.api.bookstore.repository.CategoriaRepository;
import com.jadson.api.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDados() {
        Categoria cat1 =  new Categoria(null,"Fantasia","Ficcção fantastica");
        Categoria cat2 =  new Categoria(null,"Informática","Desenvolvimento de Sistemas");
        Categoria cat3 =  new Categoria(null,"Biografias","Livros de Biografias");

        Livro l1 = Livro.builder()
                .titulo("O Senhor dos Aneis")
                .nomeAutor("J.R.R. Tolkien")
                .texto("Num pequeno buraco vivia um hobbit")
                .categoria(cat1)
                .build();
        Livro l2 = Livro.builder()
                .titulo("O Retorno do Rei")
                .nomeAutor("J.R.R. Tolkien")
                .texto("O elfo, o anão e o homem pesseguiam de longe a turba de uruk´rais")
                .categoria(cat1)
                .build();
        Livro l3 = Livro.builder()
                .titulo("Engenharia de Softaeste")
                .nomeAutor("Robert Martin")
                .texto("Lorem Ipsum")
                .categoria(cat2)
                .build();
        Livro l4 = Livro.builder()
                .titulo("Mega Mente")
                .nomeAutor("Mega Mente")
                .texto("Eu sempre fui um gênio injusticidado.")
                .categoria(cat3)
                .build();
        Livro l5 = Livro.builder()
                .titulo("O Retorno do Rei")
                .nomeAutor("J.R.R. Tolkien")
                .texto("Frodo estava agora muito distante e sem chance de retorno.")
                .categoria(cat1)
                .build();

        cat1.getLivros().add(l1);

        this.repository.saveAll(List.of(cat1,cat2,cat3));
        this.livroRepository.saveAll(List.of(l1,l2,l3,l4,l5));
    }
}
