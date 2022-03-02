package cabecera.services;

import cabecera.models.entities.Usuario;
import jakarta.ejb.Local;

import java.util.Optional;

@Local
public interface UsuarioService {
    Optional<Usuario> login(String username, String password);
}
