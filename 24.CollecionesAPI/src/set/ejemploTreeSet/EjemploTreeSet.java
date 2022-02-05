package set.ejemploTreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {
        // TODO: No duplicados, Son ordenados, desventaja rendimiento

        Set<String> ts = new TreeSet<>();
        ts.add("uno");
        ts.add("dos");
        ts.add("tres");
        ts.add("cuatro");
        ts.add("cinco");

        System.out.println("ts = " + ts);
        
        Set<Integer> numeros = new TreeSet(); // TODO: Los Ordena - Tienen que ser comparables
        // TODO: Para ponerlo en forma descendente: TreeSet((a, b) -> b.compareTo(a));
        numeros.add(1);
        numeros.add(5);
        numeros.add(4);
        numeros.add(2);
        numeros.add(3);
        numeros.add(10);

        System.out.println("numeros = " + numeros);

//        System.out.println("\nUtilizando for clasico"); TODO: Solo para List - No para Set
//        for (int i=0; i<ts.size(); i++) {
//            System.out.println(ts.get(i));
//        }

        System.out.println("\nIterando usando foreach");
        for(String s : ts) {
            System.out.println(s);
        }

        System.out.println("\nIterando usando while y iterator");
        Iterator<String> it = ts.iterator();
        while (it.hasNext()) {
            String s = it.next();
            System.out.println(s);
        }

        System.out.println("\nCon expresiones lamda");
        ts.forEach(System.out::println);
    }
}
