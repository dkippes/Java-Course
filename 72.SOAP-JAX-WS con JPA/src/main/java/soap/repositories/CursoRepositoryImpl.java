package soap.repositories;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import soap.models.Curso;

import java.util.List;

public class CursoRepositoryImpl implements CursoRepository {

    @Inject
    private EntityManager em;

    @Override
    public List<Curso> listar() {
        return em.createQuery("FROM Curso", Curso.class).getResultList();
    }

    @Override
    public Curso guardar(Curso curso) {
        em.persist(curso);
        return curso;
    }
}
