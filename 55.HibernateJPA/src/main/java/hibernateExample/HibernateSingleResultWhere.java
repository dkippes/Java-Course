package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernateSingleResultWhere {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.formaPago=?1 ", Cliente.class);
        query.setParameter(1, "debito");
        Cliente c = (Cliente) query.getSingleResult(); // 1 solo resultado
        query.setMaxResults(1); // Devuelve un solo resultado   
        System.out.println(c);
        em.close();
    }
}
