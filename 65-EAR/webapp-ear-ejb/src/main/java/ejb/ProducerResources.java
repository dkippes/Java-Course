package ejb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class ProducerResources {

    @PersistenceUnit(name = "ejemploJpa")
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
            System.out.println("Cerrando la conexion del entity manager");
        }
    }
}
