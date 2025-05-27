package com.biblioteca.sistemaBiblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.sistemaBiblioteca.entity.usuario;
import com.biblioteca.sistemaBiblioteca.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public usuario salvar(usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
