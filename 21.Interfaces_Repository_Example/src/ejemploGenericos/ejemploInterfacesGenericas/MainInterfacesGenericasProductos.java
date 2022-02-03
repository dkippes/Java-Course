package ejemploGenericos.ejemploInterfacesGenericas;

import ejemploGenericos.ejemploInterfacesGenericas.modelo.Producto;
import ejemploGenericos.ejemploInterfacesGenericas.repositorio.Direccion;
import ejemploGenericos.ejemploInterfacesGenericas.repositorio.OrdenablePaginableContableCrudRepositorio;
import ejemploGenericos.ejemploInterfacesGenericas.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class MainInterfacesGenericasProductos {
    public static void main(String[] args) {
        OrdenablePaginableContableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("Mesa", 50.52));
        repo.crear(new Producto("silla", 18.0));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 400.89));

        System.out.println("Interface CrudRepositorio");
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        System.out.println("\nInterface Paginable: ");
        List<Producto> paginable = repo.listar(1, 3);
        paginable.forEach(System.out::println);

        System.out.println("\nInterface Ordenable: ");
        List<Producto> ordenable = repo.lista("descripcion", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("\nEditar: ");
        Producto productoAEditar = new Producto("lampara", 23.0);
        productoAEditar.setId(3);
        repo.editar(productoAEditar);
        System.out.println(repo.porId(2));

        System.out.println("\nEliminar: ");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
