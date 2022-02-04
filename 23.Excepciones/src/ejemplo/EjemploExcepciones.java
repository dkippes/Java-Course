package ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {
        // UNCHECKED -> RunTimeException -> Corta la aplicacion NPE, NumberFormat, etc
        // CHECKED -> IOException, SQLException -> No corta la aplicacion

        Calculadora cal = new Calculadora();
        String valor = JOptionPane.showInputDialog("Ingrese un entero: ");
        int divisor;
        double division;

        try {
//            divisor = Integer.parseInt(valor);
//            division = cal.dividir(10, divisor);
//            System.out.println(division);

            double division2 = cal.dividir("10", "a0");
            System.out.println("division2 = " + division2);
        } catch (NumberFormatException nfe) {
            System.err.println("Se detecto una excepcion: Ingrese un valor numerico: " + nfe.getMessage());
            main(args);
        } catch (FormatoNumeroException e) {
            System.err.println(e.getMessage());
            e.printStackTrace(System.out);
        }
        catch (DivisionPorZeroException ae) {
            System.err.println("Capturamos la excepcion en tiempo de ejecucion: " + ae.getMessage());
            main(args);
        }  finally {
            System.out.println("Es opcional, pero se ejecuta siempre con o sin excepcion");
        }
        System.out.println("Continuamos con la ejecucion de nuestra app");

    }
}
