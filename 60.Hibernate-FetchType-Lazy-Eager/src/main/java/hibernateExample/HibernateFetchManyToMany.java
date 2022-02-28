package hibernateExample;

import hibernateExample.entity.Alumno;
import hibernateExample.entity.Cliente;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateFetchManyToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        List<Alumno> alumnos = em.createQuery("SELECT DISTINCT a FROM Alumno a LEFT OUTER JOIN FETCH a.cursos", Alumno.class).getResultList();
        alumnos.forEach(a -> System.out.println(a.getNombre() + ", cursos: " + a.getCursos()));
        em.close();
    }
}
