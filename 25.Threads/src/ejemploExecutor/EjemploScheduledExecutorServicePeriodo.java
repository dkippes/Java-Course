package ejemploExecutor;

import java.util.concurrent.*;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        CountDownLatch lock = new CountDownLatch(5);
        Future<?> future = executor.scheduleAtFixedRate(() -> {
            System.out.println("Hola mundo tarea ...");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                lock.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        lock.await();
        future.cancel(true);
        //TimeUnit.SECONDS.sleep(10);
        System.out.println("Alguna otra tarea en el main");
        //executor.shutdown();
    }
}
