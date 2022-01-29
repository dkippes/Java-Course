import java.util.Arrays;
import java.util.Collections;

public class OrdenamientoBurbuja {
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

        // SOLO PARA STRINGS
        for (int i = 0; i < productos.length - 1; i++) {
            for(int j = 0; j < productos.length -1 -i; j++) {
                if(productos[j+1].compareTo(productos[j]) < 0) {
                    String aux = productos[j];
                    productos[j] = productos[j+1];
                    productos[j+1] = aux;
                }
            }
        }

        // PARA CUALQUIER ARREGLO
        for (int i = 0; i < productos.length - 1; i++) {
            for(int j = 0; j < productos.length -1 -i; j++) {
                if( ((Comparable) productos[j+1]).compareTo(productos[j]) < 0) {
                    String aux = productos[j];
                    productos[j] = productos[j+1];
                    productos[j+1] = aux;
                }
            }
        }

        imprimirArray(productos);
    }
}
