import javax.swing.*;

public class SistemasNumericosVentanaDialogo {
    public static void main(String[] args) {
        String numeroStr = JOptionPane.showInputDialog(null, "Ingrese un numero entero");
        int numeroDecimal = 0;

        try {
            numeroDecimal = Integer.parseInt(numeroStr);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e);
            main(args);
            System.exit(0);
        }

        System.out.println("numeroDecimal = " + numeroDecimal);
        String mensaje = "El numero es: " + numeroDecimal + "\n";
        mensaje += "Nos vemos!";
        JOptionPane.showMessageDialog(null, mensaje);

    }
}
