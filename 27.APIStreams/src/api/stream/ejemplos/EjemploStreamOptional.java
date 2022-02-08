package api.stream.ejemplos;

import api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamOptional {
    public static void main(String[] args) {

        // Filter: Solo si coincide lo deja pasar y no lo filtra, y siempre devuelve algo
        // Retorna el objeto usuario con un optional
        // FindFist es un operador final, devuelve el primero que encuentre
        Stream<Usuario> usuario =
                Stream.of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                        .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                        .filter(u -> u.getNombre().equals("Pepex"))
                        .peek(System.out::println);

        Optional<Usuario> usuarioOptional = usuario.findFirst();
        // System.out.println(usuarioOptional.orElse(new Usuario("Diego", "kippes")).getNombre());
        // System.out.println(usuarioOptional.orElseGet(() -> new Usuario("Diego", "kippes")).getNombre());
        // System.out.println(usuarioOptional.orElseThrow());
        // System.out.println(usuarioOptional.get());
        if (usuarioOptional.isPresent()) { // Java 11 en adelante
            System.out.println(usuarioOptional.get().getNombre());
        } else {
            System.out.println("No se encontro el objeto");
        }
    }
}
