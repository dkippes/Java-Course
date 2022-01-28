package dateYCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaDateEjemplo {
    public static void main(String[] args) {
        Date fecha = new Date();
        System.out.println("fecha = " + fecha);
        
        // Para costumizar el formato
        SimpleDateFormat df = new SimpleDateFormat("'fecha: 'dd MMMM, yyyy");
        // Puedo escribirlo "dd-MM-yyyy", "dd/MM/yyyy" -> Si pongo MMMM me muestra el nombre
        // mas info: Buscar simpleDateFormat en google - Comillas simples para escribir lo que quiera
        System.out.println("df.format(fecha) = " + df.format(fecha));

        /***************** MILISEGUNDOS **********************/
        
        long j = 0;
        for(int i = 0; i < 1000000; i++){
            j += i;
        }
        
        Date fecha2 = new Date();
        long tiempoFinal = fecha2.getTime() - fecha.getTime();
        System.out.println("tiempoFinal = " + tiempoFinal);
    }
}
