package cabecera.interceptors;

import cabecera.configs.MysqlConn;
import cabecera.services.ServiceJdbcException;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.sql.Connection;
import java.util.logging.Logger;

@TransaccionalJdbc
@Interceptor
public class TransactionalInterceptor {

    @Inject
    @MysqlConn
    private Connection conn;

    @Inject
    private Logger log;

    @AroundInvoke
    public Object transactional(InvocationContext invocationContext) throws Exception {
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }

        try {
            log.info(" -------> iniciando transaccion " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass());
            Object resultado = invocationContext.proceed();
            conn.commit();
            log.info(" -------> realizando commit y finalizando transaccion " + invocationContext.getMethod().getName() +
                    " de la clase " + invocationContext.getMethod().getDeclaringClass());
            return resultado;
        } catch (ServiceJdbcException e) {
            conn.rollback();
            throw e;
        }
    }
}
