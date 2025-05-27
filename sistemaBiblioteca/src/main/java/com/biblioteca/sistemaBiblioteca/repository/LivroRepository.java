package com.biblioteca.sistemaBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.sistemaBiblioteca.entity.livro;

@Repository
public interface LivroRepository extends JpaRepository<livro, Long> {
}
