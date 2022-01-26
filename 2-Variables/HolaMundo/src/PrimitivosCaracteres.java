public class PrimitivosCaracteres {
    public static void main(String[] args) {
        char caracter = '\u0040'; // Numeros, letras, unicode
        char decimal = 64;
        System.out.println("caracter = " + caracter);
        System.out.println("decimal = " + decimal);
        System.out.println("decimal = caracter: " + (decimal == caracter));

        char simbolo = '@';
        System.out.println("simbolo = " + simbolo);
        System.out.println("simbolo = caracter: " + (simbolo == caracter) + "\n");

        System.out.println("char corresponde en byte = " + Character.BYTES);
        System.out.println("char corresponde en bites = " + Character.SIZE);
        System.out.println("char min = " + Character.MIN_VALUE);
        System.out.println("char max = " + Character.MAX_VALUE);

        char retroceso = '\b';
        char tabulador = '\t';
        char nuevaLinea = '\n';
        char retornoCarro = '\r'; // Limpia la linea
    }
}
