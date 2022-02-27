package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.Factura;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToOne {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata", "Edi");
            cliente.setFormaPago("credito");
            em.persist(cliente);

            Factura factura = new Factura("compra de oficina", 100L);
            factura.setCliente(cliente);
            e

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
