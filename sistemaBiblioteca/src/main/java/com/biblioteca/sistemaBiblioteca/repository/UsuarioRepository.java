package com.biblioteca.sistemaBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.sistemaBiblioteca.entity.usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Long> {
    boolean existsByMatricula(String matricula);
}
