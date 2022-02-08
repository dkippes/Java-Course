package api.stream.ejemplos;

import api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        // Filter: Solo si coincide lo deja pasar y no lo filtra, y siempre devuelve algo
        // Retorna el objeto usuario con un optional
        // FindFist es un operador final, devuelve el primero que encuentre
        Usuario usuario =
                Stream.of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                        .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                        .filter(u -> {
                            return u.getNombre().equals("Pepe");
                        })
                        .findFirst()
                        .get();

        System.out.println(usuario);
    }
}
