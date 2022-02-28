package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernaeFeatchResultList {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        List<Cliente> clientes = em.createQuery("SELECT DISTINCT c FROM Cliente c LEFT JOIN FETCH c.direcciones LEFT OUTER JOIN c.facturas LEFT OUTER JOIN FETCH C.detalle", Cliente.class).getResultList();

        clientes.forEach(c -> System.out.println(c.getNombre() + ", direcciones: " + c.getDirecciones()));
        em.close();
    }
}
