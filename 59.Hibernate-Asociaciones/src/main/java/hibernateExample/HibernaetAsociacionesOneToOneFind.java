package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.ClienteDetalle;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernaetAsociacionesOneToOneFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 1L);

            ClienteDetalle detalle = new ClienteDetalle(true, 5000L);
            em.persist(detalle);

            cliente.setDetalle(detalle);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
