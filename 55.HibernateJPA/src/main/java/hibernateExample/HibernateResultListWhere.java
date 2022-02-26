package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class HibernateResultListWhere {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.formaPago=?1 ");
        query.setParameter(1, "debito");
        List<Cliente> c = (List<Cliente>) query.getResultList();
        c.forEach(System.out::println);
        em.close();
    }
}
