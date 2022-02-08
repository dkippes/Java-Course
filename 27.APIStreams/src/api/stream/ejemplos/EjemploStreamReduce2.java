package api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce2 {
    public static void main(String[] args) {


        Stream<Integer> nombres = Stream.of(5, 10, 15, 20);

        // Reduce el stream en un unico resultado
        Integer resultado = nombres.reduce(0, (a, b) -> a + b);
        System.out.println("resultado = " + resultado);


    }
}
