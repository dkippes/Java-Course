package ejb.repositories;

import ejb.entities.Usuario;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Usuario> listar() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }
}
