package com.jadson.api.bookstore.repository;

import com.jadson.api.bookstore.dominio.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro,Integer> {
}
