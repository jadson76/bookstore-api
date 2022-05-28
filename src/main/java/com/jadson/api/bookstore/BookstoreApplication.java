package com.jadson.api.bookstore;

import com.jadson.api.bookstore.dominio.Categoria;
import com.jadson.api.bookstore.dominio.Livro;
import com.jadson.api.bookstore.repository.CategoriaRepository;
import com.jadson.api.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Autowired
	private CategoriaRepository repository;
	@Autowired
	private LivroRepository livroRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 =  new Categoria(null,"Fantasia","Ficcção fantastica");

		Livro l1 = Livro.builder()
				.titulo("O Senhor dos Aneis")
				.nomeAutor("J.R.R. Tolkien")
				.texto("Num pequeno buraco vivia um hobbit")
				.categoria(cat1)
				.build();

		cat1.getLivros().add(l1);

		this.repository.saveAll(List.of(cat1));
		this.livroRepository.saveAll(List.of(l1));
	}
}
