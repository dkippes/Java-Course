package hibernateExample.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

// Por cada hilo/request devuelve una sola instancia para cada app
public class JpaUtil {
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("ejemploJPA");
    }

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
