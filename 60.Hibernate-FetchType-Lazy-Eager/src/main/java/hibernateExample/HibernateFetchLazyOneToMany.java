package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        // Es mejor LAZY
        // EAGER -> Carga la consulta antes sin necesidad de llamar a su metodo get
        EntityManager em = JpaUtil.getEntityManager();

        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
