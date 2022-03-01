package ejb.service;

import ejb.models.Producto;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class ServiceEjb implements ServiceEjbRemote {

    private int contador;

    public String saludar(String nombre) {
        System.out.println("Imprimiendo dentro del ejb con instancia: " + this);
        contador++;
        System.out.println("valor del contador en metodo saludar: " + contador);
        return "Hola que tal " + nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Peras"));
        productos.add(new Producto("Manzanas"));
        productos.add(new Producto("Naranjas"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("Guardando producto: " + producto);
        Producto p = new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
