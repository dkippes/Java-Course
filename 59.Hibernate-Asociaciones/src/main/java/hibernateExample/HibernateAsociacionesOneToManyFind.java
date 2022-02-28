package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.entity.Direccion;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, 1L);

            Direccion d1 = new Direccion("Capital", 1234);
            Direccion d2 = new Direccion("Calle falsa", 123);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);

            em.merge(cliente);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
