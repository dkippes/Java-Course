package optional;

import optional.models.Computador;
import optional.repositorio.ComputadorRepositorio;
import optional.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        // Al usar un .get() con un null rompera
        Computador pc = repositorio.filtrar("rog")
                // Es igual que .get() pero mejor
                .orElseThrow(IllegalStateException::new);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println("extension = " + extension);
    }

}
