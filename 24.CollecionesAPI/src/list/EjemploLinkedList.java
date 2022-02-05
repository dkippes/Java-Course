package list;

import list.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {
        LinkedList<Alumno> enlazada = new LinkedList<>();
        enlazada.add(new Alumno("Pato", 5));
        enlazada.add(new Alumno("Cata", 6));
        enlazada.add(new Alumno("Luci", 4));
        enlazada.add(new Alumno("Jano", 7));
        enlazada.add(new Alumno("Andres", 3));
        enlazada.add(new Alumno("Zeus2", 2));
        enlazada.add(new Alumno("Zeus", 2));
        enlazada.add(2, new Alumno("Lucas", 2)); // Se guarda en enlazada posicion 2
        enlazada.add(new Alumno("Lucas", 3));

        enlazada.addFirst(new Alumno("Lucas", 3));
        enlazada.addLast(new Alumno("Lucas", 3));

        System.out.println(enlazada);
        System.out.println("Primero = " + enlazada.getFirst());
        System.out.println("Ultimo = " + enlazada.getLast());
        System.out.println("Indice 2 = " + enlazada.get(1));
        System.out.println("Peek = " + enlazada.peekFirst());

        enlazada.removeFirst(); // TODO: Lanza excepcion, para no lanzar excepcion retorna null -> enlazada.poolFirst()
        enlazada.removeLast();
        //enlazada.pop(); // TODO: Elimina y retorna
        Alumno a = new Alumno("Lele", 5);
        enlazada.addFirst(a);
        System.out.println("Indice de Lele = " + enlazada.indexOf(a));

        // TODO: Modificar la posicion
        enlazada.set(2, new Alumno("Kaia", 3));

        System.out.println("\nUsando iterator = ");
        ListIterator<Alumno> li = enlazada.listIterator();

        while (li.hasNext()) {
            Alumno alumno = li.next();
            System.out.println(alumno);
        }
    }
}
