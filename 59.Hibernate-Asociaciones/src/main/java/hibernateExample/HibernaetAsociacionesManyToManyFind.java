package hibernateExample;

import hibernateExample.entity.Alumno;
import hibernateExample.entity.Curso;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernaetAsociacionesManyToManyFind {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Alumno alumno1 = em.find(Alumno.class, 1L);
            Alumno alumno2 = em.find(Alumno.class, 2L);

            Curso curso1 = em.find(Curso.class, 1L);
            Curso curso2 = em.find(Curso.class, 2L);

            alumno1.getCursos().add(curso1);
            alumno1.getCursos().add(curso2);

            alumno2.getCursos().add(curso1);

            em.getTransaction().commit();

            System.out.println(alumno1);
            System.out.println(alumno2);

            System.out.println("******** BORRANDO UN CURSO *************");
            em.getTransaction().begin();
            Curso c2 = em.find(Curso.class, 2L);
            alumno1.getCursos().remove(c2);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
