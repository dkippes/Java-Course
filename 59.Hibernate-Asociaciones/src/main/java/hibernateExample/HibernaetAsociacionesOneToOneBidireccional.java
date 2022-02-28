package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.ClienteDetalle;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernaetAsociacionesOneToOneBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Dede", "Fritz");
            cliente.setFormaPago("cash");

            ClienteDetalle detalle = new ClienteDetalle(true, 5000L);

            cliente.addDetalle(detalle);

            em.persist(cliente);
            em.getTransaction().commit();

            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
