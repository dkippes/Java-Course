package jsf3.repositories;

import jsf3.entities.Producto;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto> {
    List<Producto> buscarPorNombre(String nombre);
}
