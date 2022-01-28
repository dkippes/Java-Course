package dateYCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaCalendarEjemplo {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(); // Por debajo hace un new

        // calendar.set(2020, Calendar.SEPTEMBER, 25, 19, 20, 10);
        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, Calendar.JULY);
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 20);
        calendar.set(Calendar.SECOND, 10);
        
        Date fecha = calendar.getTime();
        System.out.println("calendar = " + fecha);

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("formato.format(fecha) = " + formato.format(fecha));
    }
}
