package api.stream.ejemplos;

import api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterSimpleEmpty {
    public static void main(String[] args) {

        long count =
                Stream.of("Pato Guzman", "Paco Gonzalez", "", "Pepe Mena", "")
                        .filter(String::isEmpty)
                        .peek(System.out::println)
                        .count();
        System.out.println("count = " + count);
        //System.out.println(usuario);
    }
}
