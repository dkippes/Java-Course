public class ArregloInverso {
    public static void main(String[] args) {
        String[] productos = new String[7];
        productos[0] = "Kingston Pendrive";
        productos[1] = "Samsung";
        productos[2] = "Nokia";
        productos[3] = "Asus"; // Si no asigno nada es null
        productos[4] = "Macbook";
        productos[5] = "Chromecast";
        productos[6] = "Bicicleta";

        System.out.println("Con for al inverso 1 \n");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("i = " + productos[productos.length-1-i]);
        }

        System.out.println("Con for al inverso 2 \n");
        for (int i = productos.length - 1; i >= 0; i--) {
            System.out.println("i = " + productos[i]);
        }
    }
}
