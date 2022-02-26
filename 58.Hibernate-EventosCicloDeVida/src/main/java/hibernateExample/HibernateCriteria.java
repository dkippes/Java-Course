package hibernateExample;

import com.mysql.cj.log.Log;
import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.Arrays;
import java.util.List;

public class HibernateCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);

        Root<Cliente> from = query.from(Cliente.class);

        query.select(from);
        List<Cliente> clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== LISTAR WHERE EQUALS ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParam = criteria.parameter(String.class, "nombre");
        query.select(from).where(criteria.equal(from.get("nombre"), nombreParam));
        clientes = em.createQuery(query)
                .setParameter("nombre", "Dieguito")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== USANDO WHERE LIKE PARA BUSCAR CLIENTES POR NOMBRE ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<String> nombreParamLike = criteria.parameter(String.class, "nombreParam");
        query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), criteria.upper(nombreParamLike)));
        clientes = em.createQuery(query)
                .setParameter("nombreParam", "%die%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== USANDO WHERE BETWEEN ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.between(from.get("id"), 2L, 6L));
        clientes = em.createQuery(query)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTA WHERE IN ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<List> listParam = criteria.parameter(List.class, "nombres");
        query.select(from).where(from.get("nombre").in(listParam));
        clientes = em.createQuery(query)
                .setParameter("nombres", Arrays.asList("Diego", "Pepe", "Lou"))
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== FILTRAR USANDO PREDICADOS MAYOR QUE O MAYOR IGUAL ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).where(criteria.ge(from.get("id"), 5L)); // GT para mayor que - GE es mayor o igual - LT menor que
        clientes = em.createQuery(query)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTA CON LOS PREDICADOS AND Y OR ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        Predicate porNombre = criteria.equal(from.get("nombre"), "Dieguito");
        Predicate porFormaPago = criteria.equal(from.get("formaPago"), "debito");
        Predicate p3 = criteria.ge(from.get("id"), 5L);
        query.select(from).where(criteria.and(p3, criteria.or(porNombre, porFormaPago))); // se puede cambiar el and por el or
        clientes = em.createQuery(query)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTA CON ORDER BY AS DESC ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        query.select(from).orderBy(criteria.asc(from.get("nombre")), criteria.desc(from.get("apellido")));
        clientes = em.createQuery(query)
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("=========== CONSULTA POR ID ============");
        query = criteria.createQuery(Cliente.class);
        from = query.from(Cliente.class);
        ParameterExpression<Long> idParam = criteria.parameter(Long.class, "id");
        query.select(from).where(criteria.equal(from.get("id"), idParam));
        Cliente cliente = em.createQuery(query)
                .setParameter("id", 3L)
                .getSingleResult();
        System.out.println("cliente = " + cliente);

        System.out.println("=========== CONSULTA SOLO EL NOMBRE DE LOS CLIENTES ============");
        CriteriaQuery<String> queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(from.get("nombre"));
        List<String> nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTA SOLO EL NOMBRE DE LOS CLIENTES DISTINCT ============");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(from.get("nombre")).distinct(true);
        nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTA POR NOMBRES Y APELLIDOS CONCATENADOS ============");
        queryString = criteria.createQuery(String.class);
        from = queryString.from(Cliente.class);
        queryString.select(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido")));
        nombres = em.createQuery(queryString).getResultList();
        nombres.forEach(System.out::println);

        System.out.println("=========== CONSULTA DE CAMPOS PERSONALIZADOS DEL ENTITY CLIENTE ============");
        CriteriaQuery<Object[]> queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);
        queryObject.multiselect(from.get("id"), from.get("nombre"), from.get("apellido"));
        List<Object[]> registros = em.createQuery(queryObject).getResultList();
        registros.forEach(reg -> {
            Long id = (Long) reg[0];
            String nombre = (String) reg[1];
            String apellido = (String) reg[2];
            System.out.println("id= " + id + ", nombre=" + nombre + ", apellido=" + apellido);
        });

        System.out.println("=========== CONSULTA DE CAMPOS PERSONALIZADOS DEL ENTITY CLIENTE CON WHERE NOMBRE ============");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);
        queryObject.multiselect(from.get("id"), from.get("nombre"), from.get("apellido")).where(criteria.like(from.get("nombre"), "%die%"));
        registros = em.createQuery(queryObject).getResultList();
        registros.forEach(reg -> {
            Long id = (Long) reg[0];
            String nombre = (String) reg[1];
            String apellido = (String) reg[2];
            System.out.println("id= " + id + ", nombre=" + nombre + ", apellido=" + apellido);
        });

        System.out.println("=========== CONSULTA DE CAMPOS PERSONALIZADOS DEL ENTITY CLIENTE CON WHERE ID ============");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);
        queryObject.multiselect(from.get("id"), from.get("nombre"), from.get("apellido")).where(criteria.equal(from.get("id"), 3L));
        Object[] registro = em.createQuery(queryObject).getSingleResult();
        Long id = (Long) registro[0];
        String nombre = (String) registro[1];
        String apellido = (String) registro[2];
        System.out.println("id= " + id + ", nombre=" + nombre + ", apellido=" + apellido);

        System.out.println("=========== CONTAR REGISTROS DE LA CONSULTA CON COUNT ============");
        CriteriaQuery<Long> queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.count(from.get("id")));
        Long count = em.createQuery(queryLong).getSingleResult();
        System.out.println("count = " + count);

        System.out.println("=========== SUMAR DATOS DE ALGUN CAMBPO DE LA TABLA ============");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.sum(from.get("id")));
        Long sum = em.createQuery(queryLong).getSingleResult();
        System.out.println("sum = " + sum);

        System.out.println("=========== CONSULTA CON EL MAXIMO ID ============");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.max(from.get("id")));
        Long max = em.createQuery(queryLong).getSingleResult();
        System.out.println("max = " + max);

        System.out.println("=========== CONSULTA CON EL MINIMO ID ============");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);
        queryLong.select(criteria.min(from.get("id")));
        Long min = em.createQuery(queryLong).getSingleResult();
        System.out.println("min = " + min);

        System.out.println("=========== EHEMPLO VARIOS RESULTADOS DE FUNCIONES DE AGREGACION EN UNA SOLA CONSULTA ============");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);
        queryObject.multiselect(criteria.count(from.get("id")),
                criteria.sum(from.get("id")),
                criteria.max(from.get("id")),
                criteria.min(from.get("id")));
        registro = em.createQuery(queryObject).getSingleResult();
        count = (Long) registro[0];
        sum = (Long) registro[1];
        max = (Long) registro[2];
        min = (Long) registro[3];
        System.out.println("count = " + count + ", sum = " + sum + ", max = " + max + ", min = " + min);

        em.close();
    }
}
