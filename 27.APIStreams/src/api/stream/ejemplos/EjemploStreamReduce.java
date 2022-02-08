package api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {


        Stream<String> nombres = Stream.of("Pato Guzman", "Paco Gonzalez", "Paco Gonzalez", "Pepe Mena", "")
                .distinct();

        // Reduce el stream en un unico resultado
        String resultado = nombres.reduce("Resultado concateniacion ", (a, b) -> a + ", " + b);
        System.out.println("resultado = " + resultado);


    }
}
