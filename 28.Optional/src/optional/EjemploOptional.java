package optional;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {
        String nombre = "Diego";
        Optional<String> opt = Optional.of(nombre);
        System.out.println("opt = " + opt);
        System.out.println("opt.isPresent() = " + opt.isPresent());
        if(opt.isPresent()) {
            System.out.println("Hola = " + opt.get());
        }

        System.out.println("opt.isEmpty() = " + opt.isEmpty());

        opt.ifPresent(v -> System.out.println("Hello = " + v));
        
        nombre = null;
        opt = Optional.ofNullable(nombre);
        System.out.println("opt = " + opt);
        System.out.println("opt.isEmpty() = " + opt.isEmpty());

        Optional<String> pepe = Optional.empty();
        System.out.println("pepe = " + pepe);
    }
}
