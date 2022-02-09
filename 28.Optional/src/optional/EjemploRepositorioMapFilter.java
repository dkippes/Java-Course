package optional;

import optional.models.Computador;
import optional.models.Fabricante;
import optional.models.Procesador;
import optional.repositorio.ComputadorRepositorio;
import optional.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {
        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        String f= repositorio.filtrar("rog")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .filter(fab -> "intel".equalsIgnoreCase(fab.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println("f = " + f);

        f= repositorio.filtrar("ah")
                .map(Computador::getProcesador)
                .map(Procesador::getFabricante)
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println("f = " + f);
    }

}
