package dateYCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDateParserStringAFecha {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date fecha = format.parse("20-01-2021");
            System.out.println("fecha = " + fecha);
            System.out.println("format.format(fecha) = " + format.format(fecha));

            /********** COMPARAR FECHAS ***********/
            Date fecha2 = new Date();

            if(fecha.after(fecha2)) {
                System.out.println("fecha1 20-01-2021 es despues de fecha2");
            } else if(fecha.before(fecha2)) {
                System.out.println("fecha1 20-01-2021 es anterior de fecha2");
            } else if(fecha.equals(fecha2)) {
                System.out.println("fecha1 20-01-2021 es igual a fecha2");
            }

            // OTRA FORMA DE COMPRAR
            if(fecha.compareTo(fecha2) > 0) {
                System.out.println("fecha1 20-01-2021 es despues de fecha2");
            } else if(fecha.compareTo(fecha2) < 0) {
                System.out.println("fecha1 20-01-2021 es anterior de fecha2");
            } else if(fecha.compareTo(fecha2) == 0) {
                System.out.println("fecha1 20-01-2021 es igual a fecha2");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
