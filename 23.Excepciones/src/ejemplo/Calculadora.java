package ejemplo;

public class Calculadora {
    public double dividir(int numerador, int divisor) throws DivisionPorZeroException {
        if (divisor == 0) {
            // Si extiende de Exception -> Es checked, hay que poner la firma
            // Si extiende de RunTime -> Es uncheched, no nos obliga a ponerlo
            throw new DivisionPorZeroException("No se puede dividir por cero!");
        }
        return numerador / (double) divisor;
    }

    public double dividir(String numerador, String divisor) throws DivisionPorZeroException, FormatoNumeroException {
        try {
            int num = Integer.parseInt(numerador);
            int div = Integer.parseInt(divisor);
            return this.dividir(num, div);
        } catch (NumberFormatException nfe) {
            throw new FormatoNumeroException("Debe ingresar un numero en el numerador y divisor");
        }
    }
}
