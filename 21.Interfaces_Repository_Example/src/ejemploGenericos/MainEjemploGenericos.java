package ejemploGenericos;

import ejemploInterfaces.modelo.Cliente;
import ejemploInterfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainEjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Diego", "Kippes"));

        Cliente diego = clientes.iterator().next(); // Agarra el primero de la lista

        /**************** USANDO GENERICOS *******************/

        Cliente[] clientesArreglo = { new Cliente("Pedro", "Rodriguez"), new Cliente("Bea", "Lopez") };
        Integer[] enteros = { 1, 2, 3 };

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo); // Llama a T
        List<Integer> integerLista = fromArrayToList(enteros); // Llama T extends Number

        List<String> nombre = fromArrayToList(new String[]{"Diego", "Pepe"}, enteros);

        List<ClientePremium> clientePremiumsList = fromArrayToList(new ClientePremium[] { // Invoca T extends Cliente & Comparable<T>
           new ClientePremium("Paco", "Fernandez")
        });

        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumsList);
        imprimirClientes(integerLista);

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Maximo de zanahoria, arandanos y manzana es: " + maximo("zanahoria", "arandanos", "manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c) { // Puede ser T, R J cualquier letra - Con extends limitamos el generico
        return Arrays.asList(c);
    }

    public static <T extends Number> List<T> fromArrayToList(T[] c) { // Puede ser T, R J cualquier letra - Con extends limitamos el generico
        return Arrays.asList(c);
    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) { // Puede ser T, R J cualquier letra - Con extends limitamos el generico
        return Arrays.asList(c);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        System.out.println("Imprimiendo con genericos");
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<?> clientes) { // Wildcards / Comodines - Tambien se puede poner extends Client
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

}
