package com.biblioteca.sistemaBiblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.sistemaBiblioteca.entity.emprestimo;
import com.biblioteca.sistemaBiblioteca.entity.emprestimo.StatusEmprestimo;
import com.biblioteca.sistemaBiblioteca.entity.livro;
import com.biblioteca.sistemaBiblioteca.entity.usuario;
import com.biblioteca.sistemaBiblioteca.repository.EmprestimoRepository;
import com.biblioteca.sistemaBiblioteca.repository.LivroRepository;
import com.biblioteca.sistemaBiblioteca.repository.UsuarioRepository;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public emprestimo realizarEmprestimo(emprestimo emprestimo) {
        livro livro = livroRepository.findById(emprestimo.getLivro().getId())
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado."));

        usuario usuario = usuarioRepository.findById(emprestimo.getUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        if (emprestimoRepository.existsByLivroAndStatus(livro, StatusEmprestimo.EMPRESTADO)) {
            throw new IllegalStateException("Este livro já está emprestado.");
        }

        long emprestimosAtivos = emprestimoRepository.countByUsuarioAndStatus(usuario, StatusEmprestimo.EMPRESTADO);
        if (emprestimosAtivos >= 3) {
            throw new IllegalStateException("Usuário já possui 3 livros emprestados.");
        }

        emprestimo.setLivro(livro);
        emprestimo.setUsuario(usuario);
        emprestimo.setStatus(StatusEmprestimo.EMPRESTADO);

        return emprestimoRepository.save(emprestimo);
    }

    public emprestimo devolverLivro(Long emprestimoId) {
        emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new IllegalArgumentException("Empréstimo não encontrado."));

        emprestimo.setStatus(StatusEmprestimo.DEVOLVIDO);
        return emprestimoRepository.save(emprestimo);
    }

    public void deletar(Long id) {
        emprestimoRepository.deleteById(id);
    }

}
