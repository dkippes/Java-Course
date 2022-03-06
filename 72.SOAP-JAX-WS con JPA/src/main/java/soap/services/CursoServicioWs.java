package soap.services;

import jakarta.jws.WebService;
import soap.models.Curso;

import java.util.List;

@WebService
public interface CursoServicioWs {
    List<Curso> listar();
    Curso guardar(Curso curso);
}
