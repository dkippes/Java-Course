package ejb.services;

import ejb.entities.Usuario;
import ejb.repositories.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    private UsuarioRepository repository;

    @Override
    public List<Usuario> listar() {
        return repository.listar();
    }
}
