import java.lang.reflect.Array;
import java.util.Arrays;

public class ArreglosFor {
    public static void main(String[] args) {

        String[] productos = new String[7];
        productos[0] = "Kingston Pendrive";
        productos[1] = "Samsung";
        productos[2] = "Nokia";
        productos[3] = "Asus"; // Si no asigno nada es null
        productos[4] = "Macbook";
        productos[5] = "Chromecast";
        productos[6] = "Bicicleta";

        Arrays.sort(productos);

        // FOR
        System.out.println("Con for\n");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("i = " + productos[i]);
        }

        // FOR EACH
        System.out.println("Con for each\n");
        for (String prod: productos) {
            System.out.println("producto = " + prod);
        }

        // WHILE
        System.out.println("Con while\n");
        int i = 0;
        while (i < productos.length) {
            System.out.println("i = " + productos[i]);
            i++;
        }

        // DO WHILE
        System.out.println("Con while\n");
        int j = 0;
        while (j < productos.length) {
            System.out.println("j = " + productos[j]);
            j++;
        }
    }
}
