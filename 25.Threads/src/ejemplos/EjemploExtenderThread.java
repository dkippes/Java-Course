package ejemplos;

import ejemplos.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        // TODO: Con esto se ejecuta y va en paralelo cada Thread para diferentes procesadores
        Thread hilo = new NombreThread("John Doe");
        hilo.start(); // Invoca el run

        // Thread.sleep(100); // Hace una pausa
        Thread hilo2 = new NombreThread("Maria");
        hilo2.start();
        System.out.println("hilo 1 estado: " + hilo.getState());
        System.out.println("hilo 2 estado: " + hilo2.getState());
    }
}
