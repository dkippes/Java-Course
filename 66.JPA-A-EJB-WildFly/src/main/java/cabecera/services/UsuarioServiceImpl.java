package cabecera.services;

import cabecera.configs.Service;
import cabecera.models.entities.Usuario;
import cabecera.repositories.RepositoryJpa;
import cabecera.repositories.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.Optional;

@Service
@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Inject
    public UsuarioServiceImpl(@RepositoryJpa UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(u -> u.getPassword().equals(password));
        } catch (Exception throwables) {
            throw new ServiceJdbcException(throwables.getMessage(), throwables.getCause());
        }
    }
}
