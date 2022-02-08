package api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {


        IntStream num = IntStream.range(5, 20) // .rangeClosed()
                .peek(System.out::println);

        // Integer resultado = nombres.reduce(0, Integer::sum);
        // int resultado = num.sum();
        IntSummaryStatistics resultado = num.summaryStatistics();
        System.out.println("resultado = " + resultado);
        System.out.println("max: " + resultado.getMax());
        System.out.println("minx: " + resultado.getMin());
        System.out.println("promedio: " + resultado.getAverage());


    }
}
