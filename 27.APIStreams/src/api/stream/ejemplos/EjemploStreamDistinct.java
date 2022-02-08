package api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {


                Stream.of("Pato Guzman", "Paco Gonzalez", "Paco Gonzalez", "Pepe Mena", "")
                        .distinct()
                        .forEach(System.out::println);


    }
}
