package optional;

import optional.models.Computador;
import optional.repositorio.ComputadorRepositorio;
import optional.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("rog")
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se encontro"));
    }
}
