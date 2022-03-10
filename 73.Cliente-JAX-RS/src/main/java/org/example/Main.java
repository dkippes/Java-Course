package org.example;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.models.Curso;
import org.example.models.Instructor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Consumimos la otra app que formamos
        Client client = ClientBuilder.newClient();

        WebTarget rootUri = client.target("http://localhost:8080/webapp/api")
                .path("/cursos");

        System.out.println("================ por id");
        Response response = rootUri.path("/2")
                .request(MediaType.APPLICATION_JSON)
                .get();
        Curso curso = response.readEntity(Curso.class);
        System.out.println(curso);
        System.out.println(response.getStatus());
        System.out.println(response.getMediaType());

        System.out.println("================ listado");
        listar(rootUri);

        System.out.println("================ creando");
        Curso cursoNuevo = new Curso();
        cursoNuevo.setNombre("Spling Cloud");
        cursoNuevo.setDescripcion("Spling Cloud microservicios");
        cursoNuevo.setDuracion(25D);
        Instructor instructor = new Instructor();
        instructor.setId(2L);
        instructor.setNombre("Pepe");
        instructor.setApellido("Rodolfo");
        cursoNuevo.setInstructor(instructor);

        Entity<Curso> entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        curso = rootUri.request(MediaType.APPLICATION_JSON)
                .post(entityHeader, Curso.class);
        System.out.println(curso);
        System.out.println("================ listado actualizado al crear");
        listar(rootUri);

        System.out.println("================ editando");
        Curso cursoEditado = curso;
        cursoEditado.setNombre("Microservicio con spring cloud");

        entityHeader = Entity.entity(cursoNuevo, MediaType.APPLICATION_JSON);
        curso = rootUri.path("/"+curso.getId())
                .request(MediaType.APPLICATION_JSON)
                .put(entityHeader, Curso.class);
        System.out.println(curso);
        System.out.println("================ listado actualizado al edittar");
        listar(rootUri);

        System.out.println("================ eliminado");
        rootUri.path("/"+curso.getId())
                .request(MediaType.APPLICATION_JSON)
                .delete();
        listar(rootUri);
    }

    private static void listar(WebTarget rootUri) {
        Response response;
        response = rootUri
                .request(MediaType.APPLICATION_JSON)
                .get(Response.class);
        List<Curso> cursos = response.readEntity(new GenericType<List<Curso>>(){});
        cursos.forEach(System.out::println);
        System.out.println(response.getStatus());
    }
}
