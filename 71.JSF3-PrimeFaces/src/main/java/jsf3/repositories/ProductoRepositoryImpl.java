package jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jsf3.entities.Producto;

import java.util.List;

@RequestScoped
public class ProductoRepositoryImpl implements ProductoRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Producto> listar() {
        return em.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN p.categoria", Producto.class).getResultList();
    }

    @Override
    public Producto porId(Long id) {
        return em.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN p.categoria WHERE p.id=:id", Producto.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void guardar(Producto producto) {
        if (producto.getId() != null && producto.getId() > 0) {
            em.persist(producto);
        } else {
            em.merge(producto);
        }
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = porId(id);
        em.remove(producto);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return em.createQuery("SELECT p FROM Producto p LEFT OUTER JOIN p.categoria WHERE p.nombre LIKE :nombre", Producto.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }
}
