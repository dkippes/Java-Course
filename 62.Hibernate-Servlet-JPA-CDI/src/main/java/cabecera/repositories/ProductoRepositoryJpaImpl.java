package cabecera.repositories;

import cabecera.configs.Repository;
import cabecera.models.entities.Producto;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RepositoryJpa
@Repository
public class ProductoRepositoryJpaImpl implements CrudRepository<Producto> {

    @Inject
    private EntityManager em;

    @Override
    public List<Producto> listar() throws Exception {
        return em.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN FETCH p.categoria", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) throws Exception {
        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) throws Exception {
        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Producto producto = porId(id);
        em.remove(producto);
    }
}
