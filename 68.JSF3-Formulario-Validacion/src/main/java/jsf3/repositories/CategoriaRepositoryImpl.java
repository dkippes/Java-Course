package jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jsf3.entities.Categoria;
import jsf3.entities.Producto;

import java.util.List;

@RequestScoped
public class CategoriaRepositoryImpl implements CrudRepository<Categoria> {

    @Inject
    private EntityManager em;

    @Override
    public List<Categoria> listar() {
        return em.createQuery("FROM Categoria ", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) {
        if (categoria.getId() != null && categoria.getId() > 0) {
            em.persist(categoria);
        } else {
            em.merge(categoria);
        }
    }

    @Override
    public void eliminar(Long id) {
        Categoria categoria = porId(id);
        em.remove(categoria);
    }
}
