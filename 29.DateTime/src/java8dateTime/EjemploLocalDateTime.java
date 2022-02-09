package java8dateTime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        // LocalDate + LocalTime
        LocalDateTime fechaTiempo = LocalDateTime.now();
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = LocalDateTime.of(2020, Month.DECEMBER, 24, 20, 45, 5);
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = LocalDateTime.parse("2020-12-25T21:45:59");
        System.out.println("fechaTiempo = " + fechaTiempo);

        fechaTiempo = fechaTiempo.plusDays(1).plusHours(2);
        System.out.println("fechaTiempo = " + fechaTiempo);

        Month mes = fechaTiempo.getMonth();
        System.out.println("mes = " + mes);

        int dia = fechaTiempo.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = fechaTiempo.getYear();
        System.out.println("anio = " + anio);

        String f1 = fechaTiempo.format(DateTimeFormatter.ISO_DATE);
        System.out.println("f1 = " + f1);

        String f2 = fechaTiempo.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println("f2 = " + f2);
    }
}
