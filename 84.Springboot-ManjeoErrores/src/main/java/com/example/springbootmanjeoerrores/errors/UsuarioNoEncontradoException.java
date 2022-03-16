package com.example.springbootmanjeoerrores.errors;

public class UsuarioNoEncontradoException extends RuntimeException {
    public UsuarioNoEncontradoException(String id) {
        super("Usuario con ID: ".concat(id).concat(" no existe en el sistema"));
    }
}
