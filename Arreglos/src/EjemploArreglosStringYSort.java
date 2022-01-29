import java.util.Arrays;

public class EjemploArreglosStringYSort {
    public static void main(String[] args) {

        String[] productos = new String[7];
        productos[0] = "Kingston Pendrive";
        productos[1] = "Samsung";
        productos[2] = "Nokia";
        productos[3] = "Asus"; // Si no asigno nada es null
        productos[4] = "Macbook";
        productos[5] = "Chromecast";
        productos[6] = "Bicicleta";

        Arrays.sort(productos); // Orden alfabetico - Con numeros tambien

        System.out.println("productos[0] = " + productos[0]);
        System.out.println("productos[1] = " + productos[1]);
        System.out.println("productos[2] = " + productos[2]);
        System.out.println("productos[3] = " + productos[3]);
        System.out.println("productos[4] = " + productos[4]);
        System.out.println("productos[5] = " + productos[5]);
        System.out.println("productos[6] = " + productos[6]);
    }
}
