package ejb.repositories;

import ejb.entities.Usuario;

import java.util.List;

public interface UsuarioRepository {
    List<Usuario> listar();
}
