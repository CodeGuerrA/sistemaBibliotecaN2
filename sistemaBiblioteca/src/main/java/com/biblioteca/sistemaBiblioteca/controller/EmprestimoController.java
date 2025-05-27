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

import com.biblioteca.sistemaBiblioteca.entity.emprestimo;
import com.biblioteca.sistemaBiblioteca.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @GetMapping
    public List<emprestimo> listarTodos() {
        return emprestimoService.listarTodos();
    }

    @PostMapping
    public emprestimo realizarEmprestimo(@RequestBody emprestimo emprestimo) {
        return emprestimoService.realizarEmprestimo(emprestimo);
    }

    @PutMapping("/{id}/devolver")
    public emprestimo devolverLivro(@PathVariable Long id) {
        return emprestimoService.devolverLivro(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        emprestimoService.deletar(id);
    }
}
