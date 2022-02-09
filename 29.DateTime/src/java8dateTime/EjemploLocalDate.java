package java8dateTime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        Month mes = fechaActual.getMonth();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Mes español: " + mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        
        fechaActual = LocalDate.of(2020, 01, 11);
        System.out.println("fechaActual = " + fechaActual);

        fechaActual = LocalDate.parse("2020-01-01");
        System.out.println("fechaActual = " + fechaActual);

        LocalDate diaDeManiana = LocalDate.now().plusDays(1);
        System.out.println("diaDeManiana = " + diaDeManiana);

        LocalDate mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        System.out.println("mesAnteriorMismoDia = " + mesAnteriorMismoDia);

        DayOfWeek miercoles = LocalDate.parse("2020-11-01").getDayOfWeek();
        System.out.println("miercoles = " + miercoles);

        boolean esBisiesto = LocalDate.now().isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);

        boolean esAntes = LocalDate.now().isBefore(LocalDate.parse("2020-11-10"));
        System.out.println("esAntes = " + esAntes);
        
        boolean esDespues = LocalDate.now().isAfter(LocalDate.now().minusDays(1));
        System.out.println("esDespues = " + esDespues);
        
    }
}
