package cabecera.services;

import cabecera.models.Usuario;
import cabecera.repositories.UsuarioRepository;
import cabecera.repositories.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(Connection conn) {
        this.usuarioRepository = new UsuarioRepositoryImpl(conn);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(u -> u.getPassword().equals(password));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
