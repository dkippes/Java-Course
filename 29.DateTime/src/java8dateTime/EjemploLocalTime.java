package java8dateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
        LocalTime ahora = LocalTime.now();
        System.out.println(ahora);
        System.out.println("ahora.getHour() = " + ahora.getHour());

        LocalTime seisConTreinta = LocalTime.of(6, 30);
        System.out.println("seisConTreinta = " + seisConTreinta);
        
        seisConTreinta = LocalTime.parse("06:30");
        System.out.println("seisConTreinta = " + seisConTreinta);

        LocalTime siesteConTreinta = LocalTime.of(6, 30).plus(1, ChronoUnit.HOURS);
        System.out.println("siesteConTreinta = " + siesteConTreinta);

        boolean esAnterior = LocalTime.of(6, 30).isBefore(LocalTime.parse("07:30"));
        System.out.println("esAnterior = " + esAnterior);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a"); // AM - PM
        String ahoraFormateado = ahora.format(df);
        System.out.println("ahoraFormateado = " + ahoraFormateado);

        LocalTime max = LocalTime.MAX;
        LocalTime min = LocalTime.MIN;
        System.out.println("max = " + max);
        System.out.println("min = " + min);


    }
}
