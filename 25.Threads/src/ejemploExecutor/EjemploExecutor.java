package ejemploExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {
        // Framework Executor -> Es mas comodo y puede manejar pool de Threads
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable tarea = () -> {
            System.out.println("Inicio de la tarea ...");
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1); // Es como Thread.sleep()
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea...");
        };
        executor.submit(tarea);
        executor.shutdown(); // Espera a que terminen todas las tareas y lo apaga
        System.out.println("Continuando con la ejecucion del main 1");
        executor.awaitTermination(2, TimeUnit.SECONDS); // Espera a que terminen todas las tareas y continua con el metodo main
        System.out.println("Continuando con la ejecucion del main 2");
    }
}
