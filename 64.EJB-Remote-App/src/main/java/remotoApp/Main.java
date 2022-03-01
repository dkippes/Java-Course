package remotoApp;

import ejb.models.Producto;
import ejb.service.ServiceEjbRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        /**
         * Para hacerlo andar hacer install del otro proyecto, y hacer deploy de wildfly
         */
        ServiceEjbRemote service = null;

//        final Properties env = new Properties();
//        env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//        env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        env.put("jboss.naming.client.ejb.context", true);
        try {
            InitialContext ctx = new InitialContext(); // Se tiene que poner el env, pero se puso en jndi.properties
            service = (ServiceEjbRemote) ctx.lookup("ejb:/webapp-1.0-SNAPSHOT/ServiceEjb!ejb.service.ServiceEjbRemote");
            String saludo = service.saludar("Diego");
            String saludo2 = service.saludar("John");
            System.out.println(saludo);
            System.out.println(saludo2);

            Producto p = service.crear(new Producto("Sandia"));
            System.out.println("nuevo producto: " + p);

            service.listar().forEach(System.out::println);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
