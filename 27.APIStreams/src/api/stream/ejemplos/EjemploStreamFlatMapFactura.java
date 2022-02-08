package api.stream.ejemplos;

import api.stream.ejemplos.models.Factura;
import api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("John", "Doe");
        Usuario usuario2 = new Usuario("Pepe", "Perez");

        usuario.addFactura(new Factura("compras tecnologias"));
        usuario.addFactura(new Factura("compras muebles"));

        usuario2.addFactura(new Factura("bicicleta"));
        usuario2.addFactura(new Factura("notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(usuario, usuario2);
        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach(f -> System.out.println(f.getDescripcion()
                        .concat(" : cliente ")
                        .concat(f.getUsuario().toString()))
                );

    }
}
