package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.Factura;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyBidireccionalFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 1L);

            Factura f1 = new Factura("Compras supermercado", 5000L);
            Factura f2 = new Factura("Compras tecnologicas", 7000L);
            cliente.addFactura(f1)
                    .addFactura(f2);

            em.getTransaction().commit();

            System.out.println(cliente);
            System.out.println("******** BORRANDO UN CLIENTE *************");
            em.getTransaction().begin();
            Factura f3 = em.find(Factura.class, 1L);
            cliente.getFacturas().remove(f3);
            f3.setCliente(null);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
