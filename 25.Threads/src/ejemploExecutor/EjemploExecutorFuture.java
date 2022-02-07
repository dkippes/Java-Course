package ejemploExecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Framework Executor -> Es mas comodo y puede manejar pool de Threads
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea ...");
            try {
                System.out.println("Nombre del Thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1); // Es como Thread.sleep()
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("Finaliza la tarea...");
            return "Algun resultado importante de la tarea";
        };

        Future<?> resultado = executor.submit(tarea);
        executor.shutdown(); // Espera a que terminen todas las tareas y lo apaga
        System.out.println("Continuando con la ejecucion del main 1");

        System.out.println(resultado.isDone());
        System.out.println(resultado.get()); // Bloquea el thread actual hasta que devuelva un valor
        System.out.println("Continuamos...");
    }
}
