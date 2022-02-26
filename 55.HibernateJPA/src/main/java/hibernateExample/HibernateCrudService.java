package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.services.ClienteService;
import hibernateExample.services.ClienteServiceImpl;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class HibernateCrudService {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        ClienteService service = new ClienteServiceImpl(em);

        System.out.println("============= listar =============");
        List<Cliente> clientes = service.listar();
        clientes.forEach(System.out::println);

        System.out.println("============= por id =============");
        Optional<Cliente> optionalCliente = service.porId(1L);
        optionalCliente.ifPresent(System.out::println);

        System.out.println("============= agregar =============");
        Cliente cliente = new Cliente();
        cliente.setNombre("Lula");
        cliente.setApellido("Lela");
        cliente.setFormaPago("dinero");

        service.guardar(cliente);
        service.listar().forEach(System.out::println);

        System.out.println("============= Editar =============");
        cliente.setNombre("Nombre cambiado");
        service.guardar(cliente);

        service.listar().forEach(System.out::println);

        System.out.println("============= Editar =============");
        service.eliminar(7L);

        service.listar().forEach(System.out::println);

        em.close();
    }
}
