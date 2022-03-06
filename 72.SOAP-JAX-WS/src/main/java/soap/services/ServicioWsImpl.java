package soap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import soap.models.Curso;

import java.util.Arrays;
import java.util.List;

// Es staless
@WebService(endpointInterface = "soap.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {
    private int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println("Imprimiendo dentro del servicio web con instancia: " + this);
        contador++;
        System.out.println("valor de contador en el metodo saludar es " + contador);
        return "Hola que tal " + persona;
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        return Arrays.asList(new Curso("java"), new Curso("spring"), new Curso("jakarta"));
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println("Curso guardado con exito " + curso);
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(curso.getNombre());
        return nuevoCurso;
    }
}
