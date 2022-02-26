package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateEliminar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {
            Cliente c = em.find(Cliente.class, 4L);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
