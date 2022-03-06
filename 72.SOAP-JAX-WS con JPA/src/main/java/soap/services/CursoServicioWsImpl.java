package soap.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.persistence.EntityManager;
import soap.models.Curso;
import soap.repositories.CursoRepository;

import java.util.Arrays;
import java.util.List;

@Stateless
@WebService(endpointInterface = "soap.services.CursoServicioWs")
public class CursoServicioWsImpl implements CursoServicioWs {

    @Inject
    private CursoRepository repository;

    @Override
    @WebMethod
    public List<Curso> listar() {
        return repository.listar();
    }

    @Override
    @WebMethod
    public Curso guardar(Curso curso) {
        return repository.guardar(curso);
    }
}
