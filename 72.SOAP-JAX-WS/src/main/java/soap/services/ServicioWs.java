package soap.services;

import jakarta.jws.WebService;
import soap.models.Curso;

import java.util.List;

@WebService
public interface ServicioWs {
    String saludar(String persona);
    List<Curso> listar();
    Curso crear(Curso curso);
}
