package list;

import list.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class EjemploListComparableComparator {
    public static void main(String[] args) {
        List<Alumno> la = new ArrayList<>();
        la.add(new Alumno("Pato", 5));
        la.add(new Alumno("Cata", 6));
        la.add(new Alumno("Luci", 4));
        la.add(new Alumno("Jano", 7));
        la.add(new Alumno("Andres", 3));
        la.add(new Alumno("Zeus2", 2));
        la.add(new Alumno("Zeus", 2));
        la.add(2, new Alumno("Lucas", 2)); // Se guarda en la posicion 2
        la.add(new Alumno("Lucas", 3));

        // TODO: la.isEmpty()
        // TODO: la.size()
        // TODO: Para ordenar -> Ordenamiento por nota
        // TODO: Collections.sort(la);     O      Collections.sort(la, (a, b) -> a.getNota().compareTo(b.getNota);
        // TODO: la.sort(Comparator.comparing((Alumno::getNota)).reversed());

        // TODO: la.remove(new Alumno("Jano", 7)); -> Tiene que tener los atributos igual
        // TODO: la.remove(0) -> Por indice
        // TODO: la.contrains(new Alumno("Zeus", 2))
        System.out.println(la);
    }
}
