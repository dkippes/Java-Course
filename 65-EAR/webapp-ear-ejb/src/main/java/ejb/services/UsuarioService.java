package ejb.services;

import ejb.entities.Usuario;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UsuarioService {
    List<Usuario> listar();
}
