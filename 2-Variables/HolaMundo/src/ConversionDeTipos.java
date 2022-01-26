public class ConversionDeTipos {
    public static void main(String[] args) {
        String numeroStr = "50";

        int numeroInt = Integer.parseInt(numeroStr);

        String realStr = "98765.43";
        double realDouble = Double.parseDouble(realStr);

        String logicoStr = "true";
        boolean logicoBoolean = Boolean.parseBoolean(logicoStr);

        /*---------------------*/
        int otroNumeroInt = 100;
        String otroNumeroString = Integer.toString(otroNumeroInt);
        otroNumeroString = String.valueOf(otroNumeroInt); // Puede recibir otro string

        /*---------------------*/
        // CAST
        int i = 10000;
        short s = (short)i; // casting - Cuando se pasa del max no puede convertirse
        long l = i;

    }
}
