package api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        // TODO: CREANDO STREAM 1
        Stream<String> nombre = Stream.of("Pato", "Paco", "Pepa", "Pepe");
        String[] arr = {"Pato", "Paco", "Pepa", "Pepe"};
        // TODO: CREANDO STREAM 2
        nombre = Arrays.stream(arr);
        // TODO: CREANDO STREAM 3
        nombre = Stream.<String>builder()
                .add("Pato")
                .add("Paco")
                .add("pepa")
                .add("pepe")
                .build();
        // TODO: CREANDO STREAM 4
        List<String> lista = new ArrayList<>();
        lista.add("Pato");
        lista.add("Paco");
        lista.add("Pepa");
        lista.add("Pepe");
        lista.stream();



        // For each -> Operador final, no modifica el flujo ni devuelve nada
        nombre.forEach(System.out::println);
    }
}
