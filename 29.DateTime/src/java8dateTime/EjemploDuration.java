package java8dateTime;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {
        LocalDateTime fecha1 = LocalDateTime.now();
        LocalDateTime fecha2 = LocalDateTime.now().plusHours(1);
        Duration lapsus = Duration.between(fecha1, fecha2);
        System.out.println("lapsus = " + lapsus);
        System.out.println("lapsus.getSeconds() = " + lapsus.getSeconds());
        System.out.println("lapsus.plusHours(5) = " + lapsus.plusHours(5));


    }
}
