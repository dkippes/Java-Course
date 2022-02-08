package api.stream.ejemplos;

import api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFlatMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres =
                Stream.of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                        .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                        // Map devuelve un objeto, FlatMap devuelve un Stream siempre
                        .flatMap(u -> { // Se aplana en uno solo
                            if(u.getNombre().equals("Pepe")) {
                                return Stream.of(u);
                            }
                            return Stream.empty();
                        })
                        .peek(System.out::println);

        System.out.println(nombres.count());
    }
}
