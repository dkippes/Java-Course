package ejemploInterfaces;

import ejemploInterfaces.modelo.Cliente;
import ejemploInterfaces.repositorio.ClienteListRepositorio;
import ejemploInterfaces.repositorio.Direccion;
import ejemploInterfaces.repositorio.OrdenablePaginableContableCrudRepositorio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrdenablePaginableContableCrudRepositorio repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "Gonzáles"));
        repo.crear(new Cliente("Luci", "Martinez"));
        repo.crear(new Cliente("Diego", "Kippes"));

        System.out.println("Interface CrudRepositorio");
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("\nInterface Paginable: ");
        List<Cliente> paginable = repo.listar(1, 3);
        paginable.forEach(System.out::println);

        System.out.println("\nInterface Ordenable: ");
        List<Cliente> ordenable = repo.lista("apellido", Direccion.ASC);
        ordenable.forEach(System.out::println);

        System.out.println("\nEditar: ");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        System.out.println(repo.porId(2));

        System.out.println("\nEliminar: ");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
    }
}
