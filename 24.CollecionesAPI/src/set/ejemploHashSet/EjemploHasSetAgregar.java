package set.ejemploHashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EjemploHasSetAgregar {
    public static void main(String[] args) {

        // TODO: No acepta duplicados ni se puede ordenar
        Set<String> hs = new HashSet<>();
        hs.add("uno");
        hs.add("dos");
        hs.add("tres");
        hs.add("cuatro");
        hs.add("cinco");
        System.out.println(hs);

        // Collections.sort(hs); -> Los Set no se pueden ordenar

        System.out.println("Permite elementos publicados? " + hs.add("tres"));

        System.out.println("\nIterando usando foreach");
        for(String s : hs) {
            System.out.println(s);
        }

        System.out.println("\nIterando usando while y iterator");
        Iterator<String> it = hs.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        System.out.println("\nCon expresiones lamda");
        hs.forEach(System.out::println);
    }
}
