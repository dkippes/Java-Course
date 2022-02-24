package cabecera.repositories;

import cabecera.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
