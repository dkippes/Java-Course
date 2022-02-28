package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateFetchLazyOneToManyJoinFetch {
    public static void main(String[] args) {
        // Es mejor LAZY -> Si no le ponemos el tipo de fetch en la relacion siempre es LAZY
        // EAGER -> Carga la consulta antes sin necesidad de llamar a su metodo get
        EntityManager em = JpaUtil.getEntityManager();

        Cliente cliente = em.createQuery("SELECT c FROM Cliente c LEFT OUTER JOIN FETCH c.direcciones LEFT JOIN FETCH c.detalle WHERE c.id=:id", Cliente.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        System.out.println(cliente.getNombre() + ", detalle: " + cliente.getDetalle());
        em.close();
    }
}
