package ejb.service;

import ejb.models.Producto;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface ServiceEjbLocal {
    String saludar(String nombre);
    List<Producto> listar();
    Producto crear(Producto producto);
}
