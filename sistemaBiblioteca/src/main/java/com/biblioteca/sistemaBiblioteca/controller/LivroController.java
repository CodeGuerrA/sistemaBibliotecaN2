package com.biblioteca.sistemaBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.sistemaBiblioteca.entity.livro;
import com.biblioteca.sistemaBiblioteca.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<livro> listarTodos() {
        return livroService.listarTodos();
    }

    @GetMapping("/{id}")
    public livro buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    @PostMapping
    public livro criar(@RequestBody livro livro) {
        return livroService.salvar(livro);
    }

    @PutMapping("/{id}")
    public livro atualizar(@PathVariable Long id, @RequestBody livro livro) {
        livro existente = livroService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livro.setId(existente.getId());
        return livroService.salvar(livro);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroService.deletar(id);
    }
}