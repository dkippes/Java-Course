package hibernateExample;

import hibernateExample.entity.Alumno;
import hibernateExample.entity.Curso;
import hibernateExample.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class HibernaetAsociacionesManyToManyBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            Alumno alumno1 = new Alumno("Lele", "Pancha");
            Alumno alumno2 = new Alumno("Jero", "Rejo");

            Curso curso1 = new Curso("Java", "Diego");
            Curso curso2 = new Curso("Smalltalk", "Pacho");

            alumno1.addCurso(curso1);
            alumno1.addCurso(curso2);

            alumno2.getCursos().add(curso1);

            em.persist(alumno1);
            em.persist(alumno2);
            em.getTransaction().commit();

            System.out.println(alumno1);
            System.out.println(alumno2);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
