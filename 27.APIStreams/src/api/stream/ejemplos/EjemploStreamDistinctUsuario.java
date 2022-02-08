package api.stream.ejemplos;

import api.stream.ejemplos.models.Usuario;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {

        IntStream largoNombres =
                Stream.of("Pato Guzman", "Paco Gonzalez", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena", "Pepe Garcia")
                        .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                        .distinct()
                        .mapToInt(u -> u.toString().length());

        largoNombres.forEach(System.out::println);
    }
}
