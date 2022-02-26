package hibernateExample;

import com.mysql.cj.log.Log;
import hibernateExample.dominio.ClienteDTO;
import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

public class HibernateQL {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("=========== CONSULTAR TODOS ============");
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTAR POR ID ============");
        Cliente cliente = em.createQuery("SELECT c FROM Cliente c WHERE c.id=:id", Cliente.class)
                .setParameter("id", 3L)
                .getSingleResult();
        System.out.println(cliente);

        System.out.println("=========== CONSULTAR SOLO EL NOMBRE POR EL ID ============");
        String nombreCliente = em.createQuery("SELECT c.nombre FROM Cliente c WHERE c.id=:id", String.class)
                .setParameter("id", 3L)
                .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("=========== CONSULTAR POR CAMPOS PERSONALIZADOS ============");
        Object[] objectCliente = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c WHERE c.id=:id", Object[].class)
                .setParameter("id", 3L)
                .getSingleResult();
        Long id = (Long) objectCliente[0];
        String nombre = (String) objectCliente[1];
        String apellido = (String) objectCliente[2];
        System.out.println(id + " " + nombre + " " + apellido);

        System.out.println("=========== CONSULTAR POR CAMPOS PERSONALIZADOS LISTA ============");
        List<Object[]> registros = em.createQuery("SELECT c.id, c.nombre, c.apellido FROM Cliente c", Object[].class)
                .getResultList();
        registros.forEach(req -> {
            Long idR = (Long) req[0];
            String nombreR = (String) req[1];
            String apellidoR = (String) req[2];
            System.out.println(idR + " " + nombreR + " " + apellidoR);
        });

        System.out.println("=========== CONSULTAR POR CLIENTE Y FORMA DE PAGO ============");
        registros = em.createQuery("SELECT c, c.formaPago FROM Cliente c", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            Cliente c = (Cliente) reg[0];
            String formaPago = (String) reg[1];
            System.out.println("cliente: " + c + " - formaPago: " + formaPago);
        });

        System.out.println("=========== CONSULTAR QUE PUEBLA Y DEVUELVE OBJETO ENTITY DE UNA CLASE PERSONALIZADA ============");
        clientes = em.createQuery("SELECT new Cliente(c.nombre, c.apellido) FROM Cliente c", Cliente.class)
                        .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTAR QUE PUEBLA Y DEVUELVE OBJETO DTO DE UNA CLASE PERSONALIZADA ============");
        List<ClienteDTO> clientesDto = em.createQuery("SELECT new hibernateExample.dominio.ClienteDTO(c.nombre, c.apellido) FROM Cliente c", ClienteDTO.class)
                .getResultList();
        clientesDto.forEach(System.out::println);

        System.out.println("=========== CONSULTAR CON NOMBRES DE CLIENTES ============");
        List<String> nombres = em.createQuery("SELECT c.nombre FROM Cliente c", String.class)
                        .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTAR CON NOMBRES DE CLIENTES DISTINCT ============");
        nombres = em.createQuery("SELECT DISTINCT (c.nombre) FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTAR CON NUMERO DE FORMAS DE PAGO UNICOS ============");
        Long totalFormaPagos = em.createQuery("SELECT COUNT(c.formaPago) FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println("totalFormaPagos = " + totalFormaPagos);

        System.out.println("=========== CONSULTAR CON NOMBRE Y APELLIDO CONCATENADOS ============");
//        nombres = em.createQuery("SELECT CONCAT(c.nombre, ' ', c.apellido) FROM Cliente c", String.class)
//                .getResultList();

        // Otra forma como la de arriba
        nombres = em.createQuery("SELECT c.nombre || ' ' || c.apellido FROM Cliente c", String.class)
                .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTAR CON NOMBRE Y APELLIDO CONCATENADOS EN MAYUSCULA ============");
        nombres = em.createQuery("SELECT UPPER(c.nombre || ' ' || c.apellido) FROM Cliente c", String.class)
                .getResultList();

        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTAR PARA BUSCAR POR NOMBRE ============");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :parametro", Cliente.class)
                .setParameter("parametro", "%DIE%")
                .getResultList();

        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTAR POR RANGOS ============");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.nombre BETWEEN 'J' AND 'Q'", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTAR POR ORDEN ============");
        clientes = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre DESC, c.apellido DESC", Cliente.class)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTAR CON TOTAL DE REGISTROS DE LA TABLA ============");
        Long total = em.createQuery("SELECT COUNT(c) AS total FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println("total = " + total);

        System.out.println("=========== CONSULTA CON VALOR MINIMO DEL ID ============");
        Long min = em.createQuery("SELECT MIN(c.id) AS minimo FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println("min = " + min);

        System.out.println("=========== CONSULTA CON MAX / ULTIMO ID ============");
        Long max = em.createQuery("SELECT MAX(c.id) AS minimo FROM Cliente c", Long.class)
                .getSingleResult();
        System.out.println("max = " + max);

        System.out.println("=========== CONSULTA CON NOMBRE Y SU LARGO ============");
        registros = em.createQuery("SELECT c.nombre, LENGTH(c.nombre) FROM Cliente c", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre = " + nom + ", largo = " + largo);
        });

        System.out.println("=========== CONSULTA CON NOMBRE MAS CORTO ============");
        Integer minLargoNombre = em.createQuery("SELECT MIN(LENGTH(c.nombre)) FROM Cliente c", Integer.class)
                .getSingleResult();
        System.out.println("minLargoNombre = " + minLargoNombre);

        System.out.println("=========== CONSULTA CON NOMBRE MAS LARGO ============");
        Integer maxLargoNombre = em.createQuery("SELECT MAX(LENGTH(c.nombre)) FROM Cliente c", Integer.class)
                .getSingleResult();
        System.out.println("maxLargoNombre = " + maxLargoNombre);

        System.out.println("=========== CONSULTA RESUMEN FUNCIONES AGREGACIONES COUNT MIN MAX AVG SUM ============");
        Object[] estadisticas = em.createQuery("SELECT MIN(c.id), MAX(c.id), SUM(c.id), COUNT(c.id), AVG(LENGTH(c.nombre)) FROM Cliente c", Object[].class)
                        .getSingleResult();
        min = (Long) estadisticas[0];
        max = (Long) estadisticas[1];
        Long sum = (Long) estadisticas[2];
        Long count = (Long) estadisticas[3];
        Double avg = (Double) estadisticas[4];
        System.out.println("min = " + min + ", max = " + max + ", sum = " + sum + ", count = " + count + ", avg = " + avg);

        System.out.println("=========== CONSULTA CON NOMBRE MAS CORTO Y SU LARGO ============");
        registros = em.createQuery("SELECT c.nombre, LENGTH(c.nombre) FROM Cliente c " +
                        "WHERE LENGTH(c.nombre) = (SELECT MIN(LENGTH(c.nombre)) FROM Cliente c)", Object[].class)
                        .getResultList();
        registros.forEach(reg -> {
            String nom = (String) reg[0];
            Integer largo = (Integer) reg[1];
            System.out.println("nombre = " + nom + ", largo = " + largo);
        });

        System.out.println("=========== CONSULTA PARA OBTENER EL ULTIMO REGISTRO ============");
        Cliente ultimoCliente = em.createQuery("SELECT c FROM Cliente c WHERE c.id = (SELECT MAX(c.id) FROM Cliente c)", Cliente.class)
                        .getSingleResult();
        System.out.println("ultimoCliente = " + ultimoCliente);

        System.out.println("=========== CONSULTA WHERE IN ============");
        clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id IN :ids", Cliente.class)
                .setParameter("ids", Arrays.asList(1L, 2L, 10L, 40L))
                .getResultList();
        clientes.forEach(System.out::println);

        em.close();
    }
}
