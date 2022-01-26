package tipoString;

public class TipoString {
    public static void main(String[] args) {
        String curso = "Programacion Java";
        String curso2 = new String("Programacion Java");
        String curso3 = "Programacion jAVA";

        boolean esIgual = curso == curso2; // Es la referencia, el espacio de memoria
        System.out.println("esIgual = " + esIgual);

        esIgual = curso.equals(curso2);
        System.out.println("esIgualConEqual = " + esIgual);

        esIgual = curso.equalsIgnoreCase(curso3);
        System.out.println("esIgualConIgnoreCase = " + esIgual);

        String curso4 = "Programacion Java";
        esIgual = curso == curso4;
        System.out.println("esIgual asigna el mismo espacio de memoria porque ya existe = " + esIgual);
    }
}
