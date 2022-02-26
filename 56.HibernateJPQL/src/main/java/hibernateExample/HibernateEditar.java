package hibernateExample;

import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernateEditar {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();

            Cliente clienteAEditar = em.find(Cliente.class, 3L);

            clienteAEditar.setNombre("Dieguito");
            clienteAEditar.setApellido("rodriguez");
            clienteAEditar.setFormaPago("debito");
            em.merge(clienteAEditar);

            System.out.println("el id del cliente registrado es: " + clienteAEditar.getId());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
