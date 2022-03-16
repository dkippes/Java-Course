package com.example.springbootmanjeoerrores.services;

import com.example.springbootmanjeoerrores.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista = Arrays.asList(
                new Usuario(1, "Diego", "Kippes"),
                new Usuario(2, "Pepa", "Fabio"),
                new Usuario(3, "Lele", "Mac"),
                new Usuario(4, "Gonza", "Apple"),
                new Usuario(5, "Ruben", "Qwerty"),
                new Usuario(6, "Joa", "Huo"),
                new Usuario(6, "Nacho", "Pepe")
        );
    }

    @Override
    public List<Usuario> listar() {
        return this.lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;
        for (Usuario usuario : this.lista) {
            if (usuario.getId() == id) {
                resultado = usuario;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = obtenerPorId(id);
        return Optional.ofNullable(usuario);
    }
}
