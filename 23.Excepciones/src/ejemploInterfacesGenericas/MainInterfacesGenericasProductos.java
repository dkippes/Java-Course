package ejemploInterfacesGenericas;

import ejemploInterfacesGenericas.modelo.Producto;
import ejemploInterfacesGenericas.repositorio.Direccion;
import ejemploInterfacesGenericas.repositorio.OrdenablePaginableContableCrudRepositorio;
import ejemploInterfacesGenericas.repositorio.excepciones.AccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.EscrituraAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.LecturaAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class MainInterfacesGenericasProductos {
    public static void main(String[] args) {

        try {

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
            repo.eliminar(0);
            repo.listar().forEach(System.out::println);

        } catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException e) {
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
