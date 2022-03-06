package soap.repositories;

import soap.models.Curso;

import java.util.List;

public interface CursoRepository {
    List<Curso> listar();
    Curso guardar(Curso curso);
}
