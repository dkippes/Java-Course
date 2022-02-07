package lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {
        // Podemos hacer algo y devolverlo, es como Supplier+Consumer
        // Siempre devuelve
        Function<String, String> f1 = param -> {
            return "Hola que tal!" + param;
        };
        String resultado = f1.apply("Diego");
        System.out.println(resultado);

        Function<String, String> f2 = String::toUpperCase;
        System.out.println(f2.apply("diego"));

        // TODO: BiFunction
        BiFunction<String, String, String> f3 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        String r2 = f3.apply("Diego", "kippes");
        System.out.println(r2);

        BiFunction<String , String , Integer> f4 = String::compareTo;
        System.out.println(f4.apply("Diego", "diego2"));
    }
}
