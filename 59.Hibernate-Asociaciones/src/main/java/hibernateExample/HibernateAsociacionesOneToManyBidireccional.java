package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.Direccion;
import hibernateExample.entity.Factura;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Pepe", "Rodriguez");
            cliente.setFormaPago("paypal");

            Factura f1 = new Factura("Compras supermercado", 5000L);
            Factura f2 = new Factura("Compras tecnologicas", 7000L);
            cliente.addFactura(f1)
                    .addFactura(f2);

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
