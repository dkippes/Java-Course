package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.Direccion;
import hibernateExample.entity.Factura;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("die", "kip");
            cliente.setFormaPago("mercado pago");
            em.persist(cliente);

            Direccion d1 = new Direccion("Capital", 1234);
            Direccion d2 = new Direccion("Calle falsa", 123);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);

            em.persist(cliente);

            em.getTransaction().commit();

            System.out.println(cliente);


            System.out.println("******** BORRANDO UN CLIENTE *************");
            em.getTransaction().begin();
            cliente = em.find(Cliente.class, cliente.getId());
            cliente.getDirecciones().remove(d1);
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
