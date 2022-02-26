package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class HibernatePorId {
    public static void main(String[] args) {

        // 1 Sola consulta para 2 ejecuciones
        EntityManager em = JpaUtil.getEntityManager();
        Cliente cliente = em.find(Cliente.class, 3L); // Funciona como un WHERE
        System.out.println(cliente);

        Cliente cliente2 = em.find(Cliente.class, 4L); // Funciona como un WHERE
        System.out.println(cliente2);

        em.close();
    }
}
