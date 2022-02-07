package lambda;

import lambda.modelo.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;

public class EjemploConsumerSupplier {
    public static void main(String[] args) {
        // Una expresion lambda es una interface funcional
        // TODO: Un consumer no devuelve nada
        Consumer<Date> consumidor = fecha -> { // Se puede poner (Date fecha)
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        // TODO: Pasando 2 argumentos
        BiConsumer<String, Integer> cosumidorB1 = (nombre, edad) -> System.out.println(nombre + ", tiene " + edad + " años!");
        cosumidorB1.accept("pepe", 20);

        // TODO:
        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola mundo lambda");

        // TODO:
        List<String> nombresList = Arrays.asList("andres", "pepe", "luz");
        nombresList.forEach(consumidor2);

        // TODO:
        Usuario usuario = new Usuario();

        BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario, "Diego");
        System.out.println("Nombre usuario: " + usuario.getNombre());

        // TODO: Supplier -> Siempre hay un return
        Supplier<String> proveedor = () -> {
            return "Hola mundo lambda supplier";
        };
        System.out.println(proveedor.get());

        // TODO: En una sola linea
        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario1 = creaUsuario.get();
    }
}
