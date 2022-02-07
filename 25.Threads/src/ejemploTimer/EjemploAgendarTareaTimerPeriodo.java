package ejemploTimer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contadorAtomic = new AtomicInteger(3);
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                int i = contadorAtomic.getAndDecrement();
                if(contadorAtomic.getAndDecrement() > 0) {
                    toolkit.beep();
                    System.out.println("Tarea periodica en: " + new Date() + " nombre del Thread: " + Thread.currentThread().getName());
                } else {
                    System.out.println("Finaliza el tiempo");
                }
            }
        }, 5000, 10000);

        System.out.println("Agendamos una tarea para 10 segundos mas...");
    }
}
