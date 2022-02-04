package ejemploInterfacesGenericas;

import ejemploInterfacesGenericas.modelo.ClienteG;
import ejemploInterfacesGenericas.repositorio.Direccion;
import ejemploInterfacesGenericas.repositorio.OrdenablePaginableContableCrudRepositorio;
import ejemploInterfacesGenericas.repositorio.excepciones.AccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.EscrituraAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.excepciones.LecturaAccesoDatoException;
import ejemploInterfacesGenericas.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class MainInterfacesGenericasClientes {
    public static void main(String[] args) {

        try {

            OrdenablePaginableContableCrudRepositorio<ClienteG> repo = new ClienteListRepositorio();
            repo.crear(new ClienteG("Jano", "Pérez"));
            repo.crear(new ClienteG("Bea", "Gonzáles"));
            repo.crear(new ClienteG("Luci", "Martinez"));
            repo.crear(new ClienteG("Diego", "Kippes"));
            repo.crear(new ClienteG("Diego", "Kippes"));

            System.out.println("Interface CrudRepositorio");
            List<ClienteG> clientes = repo.listar();
            clientes.forEach(System.out::println);

            System.out.println("\nInterface Paginable: ");
            List<ClienteG> paginable = repo.listar(1, 3);
            paginable.forEach(System.out::println);

            System.out.println("\nInterface Ordenable: ");
            List<ClienteG> ordenable = repo.lista("apellido", Direccion.ASC);
            ordenable.forEach(System.out::println);

            System.out.println("\nEditar: ");
            ClienteG beaActualizar = new ClienteG("Bea", "Mena");
            beaActualizar.setId(2);
            repo.editar(beaActualizar);
            System.out.println(repo.porId(2));

            System.out.println("\nEliminar: ");
            repo.eliminar(2);
            repo.listar().forEach(System.out::println);

        } catch (LecturaAccesoDatoException e) {
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException e) {
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e) {
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
