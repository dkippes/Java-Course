package cliente.ws;

import soap.services.Curso;
import soap.services.ServicioWs;
import soap.services.ServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        ServicioWs servicie = new ServicioWsImplService().getServicioWsImplPort();
        System.out.println("el saludo " + servicie.saludar("Diego"));

        Curso curso = new Curso();
        curso.setNombre("Angular");
        Curso respuesta = servicie.crear(curso);
        System.out.println("nuevo curso " + curso.getNombre());

        servicie.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
