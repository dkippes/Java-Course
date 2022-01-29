import java.util.Arrays;
import java.util.Collections;

public class ArregloForInversoMutable {
    public static void arregloInverso(String[] arreglos) {
        int total1 = arreglos.length;
        int total2 = arreglos.length;
        for (int i = 0; i < total2; i++) {
            String actual = arreglos[i];
            String inverso = arreglos[total1-1-i];
            arreglos[i] = inverso;
            arreglos[total1-1-i] = actual;
            total2--;
        }
    }

    public static void imprimirArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }
    }

    public static void main(String[] args) {
        String[] productos = new String[7];
        productos[0] = "Kingston Pendrive";
        productos[1] = "Samsung";
        productos[2] = "Nokia";
        productos[3] = "Asus"; // Si no asigno nada es null
        productos[4] = "Macbook";
        productos[5] = "Chromecast";
        productos[6] = "Bicicleta";

        arregloInverso(productos);

        imprimirArray(productos);

        System.out.println("\n con Collections");
        // Se puede hacer con list -> Collections.reverse(Arrays.asList());
        Collections.reverse(Arrays.asList(productos));

        imprimirArray(productos);
    }
}
