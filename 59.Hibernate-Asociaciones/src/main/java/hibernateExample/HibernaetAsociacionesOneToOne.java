package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.ClienteDetalle;
import hibernateExample.entity.Factura;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernaetAsociacionesOneToOne {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Dede", "Fritz");
            cliente.setFormaPago("cash");
            em.persist(cliente);

            ClienteDetalle detalle = new ClienteDetalle(true, 5000L);
            em.persist(detalle);

            cliente.setDetalle(detalle);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
