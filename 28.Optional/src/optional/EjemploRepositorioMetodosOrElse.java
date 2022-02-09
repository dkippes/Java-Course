package optional;

import optional.models.Computador;
import optional.repositorio.ComputadorRepositorio;
import optional.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador defecto = valorDefecto();
        Computador pc = repositorio.filtrar("rog")
                .orElse(valorDefecto()); // De todas maneras va a ocupar recursos y va a usar la instancia
        System.out.println("pc = " + pc);

        pc = repositorio.filtrar("macbook")
                .orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto); // Es mejor que el anterior

        System.out.println("pc2 = " + pc);
    }

    public static Computador valorDefecto() {
        System.out.println("Obteniendo valor por defecto");
        return new Computador("HP Omen", "LA0001");
    }
}
