import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemasNumericosScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIngrese un numero entero: ");
        int numeroDecimal = 0;

        try {
            numeroDecimal = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println(e);
            main(args);
            System.exit(0);
        }

        System.out.println("numeroDecimal = " + numeroDecimal);
        String mensaje = "El numero es: " + numeroDecimal + "\n";
        mensaje += "Nos vemos!";
        System.out.println(mensaje);

    }
}
