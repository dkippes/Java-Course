package operadores;

public class OperadoresLogicos {
    public static void main(String[] args) {
        boolean b1 = false && true; // Corta antes porque sabe que es false
        boolean b2 = true || false; // Corta antes porque sabe que es true

        // Ternario
        String variable = 7 == 7
                ? "si es verdadero"
                : "no es falso";

        String texto = "Creando un objeto de la clase String ... que tal!";
        Integer num = 7;
        Number num2 = 10.30;

        boolean b3 = texto instanceof String;
        System.out.println("texto es de tipo String = " + b3);

        boolean b4 = texto instanceof Object;
        System.out.println("texto es de tipo Object = " + b4);

        boolean b5 = num instanceof Integer;
        System.out.println("num es de tipo Integer = " + b5);

        boolean b6 = num instanceof Object;
        System.out.println("texto es de tipo Long = " + b6);

        boolean b7 = num2 instanceof Double;
        System.out.println("num2 generico es de tipo Double = " + b7);
    }
}
