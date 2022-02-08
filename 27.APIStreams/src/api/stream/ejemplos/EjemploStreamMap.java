package api.stream.ejemplos;

import api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        // Map -> Siempre algun dato cambiado, siempre es un return
        // Peek: Funciona como un foreach (inspecciona), sirve como debug. Ver elementos antes de su modificacion
        // Si no esta el peek no se puede imprimir en el intermedio
        Stream<Usuario> nombres =
                Stream.of("Pato Guzman", "Paco Gonzalez", "Pepa Gutierrez", "Pepe Mena")
                        .peek(e -> System.out.println("Antes del primer map: " + e))
                        .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                        .peek(e -> System.out.println("Despues del primer map: " + e + " - " + e.getClass()))
                        .map(usuario -> {
                            String nombre = usuario.getNombre().toLowerCase();
                            usuario.setNombre(nombre);
                            return usuario;
                        })
                        .peek(e -> System.out.println("Ultimo peek : " + e));

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(u -> System.out.println(u.getNombre()));
    }
}
