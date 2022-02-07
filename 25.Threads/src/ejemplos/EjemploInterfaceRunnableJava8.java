package ejemplos;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {
        // TODO: Java 8 = llamado Java Funcional
        // TODO: Se ejecuta los Threads en paralelo

        Thread main = Thread.currentThread();
        Runnable viaje = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            System.out.println("No continua con la ejecucion del metodo main, su estado: " + main.getState());
        };

        // Esto es asyncrono - No se bloquea uno con el otro
        Thread v1 = new Thread(viaje, "Isla de Pascua"); // Por constructor pasamos el ejecutable
        Thread v2 = new Thread(viaje, "Robinson Crusoe");
        Thread v3 = new Thread(viaje, "Juan Fernandez");
        Thread v4 = new Thread(viaje, "Isla de Chiloe");

        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v1.join(); // Espera que todos terminen y despues continua con el proceso del main

        // TODO: Si no le pongo tiempo se ejecuta al principio
        //Thread.sleep(10000); -> Es un metodo estatico y se ejecuta en la clase que esta
        System.out.println("\nContinuando con la ejecucion del metodo main");
    }
}
