package com.biblioteca.sistemaBiblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.sistemaBiblioteca.entity.livro;
import com.biblioteca.sistemaBiblioteca.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public livro salvar(livro livro) {
        return livroRepository.save(livro);
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }
}
