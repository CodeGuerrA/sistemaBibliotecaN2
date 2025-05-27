package com.biblioteca.sistemaBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.sistemaBiblioteca.entity.emprestimo;
import com.biblioteca.sistemaBiblioteca.entity.emprestimo.StatusEmprestimo;
import com.biblioteca.sistemaBiblioteca.entity.livro;
import com.biblioteca.sistemaBiblioteca.entity.usuario;

@Repository
public interface EmprestimoRepository extends JpaRepository<emprestimo, Long> {

    boolean existsByLivroAndStatus(livro livro, StatusEmprestimo status);

    long countByUsuarioAndStatus(usuario usuario, StatusEmprestimo status);
}
