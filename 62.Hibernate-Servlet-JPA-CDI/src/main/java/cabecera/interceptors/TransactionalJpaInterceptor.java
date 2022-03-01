package cabecera.interceptors;

import cabecera.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import jakarta.persistence.EntityManager;

import java.util.logging.Logger;

@TransaccionalJpa
@Interceptor
public class TransactionalJpaInterceptor {

    @Inject
    private EntityManager em;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocationContext) throws Exception {

        try {
            log.info(" -------> iniciando transaccion " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass());
            em.getTransaction().begin();
            Object resultado = invocationContext.proceed();
            em.getTransaction().commit();
            log.info(" -------> realizando commit y finalizando transaccion " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass());
            return resultado;
        } catch (ServiceJdbcException e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
