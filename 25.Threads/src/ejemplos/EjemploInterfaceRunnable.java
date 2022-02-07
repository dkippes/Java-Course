package ejemplos;

import ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {
        // TODO: Se ejecuta los Threads en paralelo
        new Thread(new ViajeTarea("Isla de Pascua")).start(); // Por constructor pasamos el ejecutable
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernandez")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
