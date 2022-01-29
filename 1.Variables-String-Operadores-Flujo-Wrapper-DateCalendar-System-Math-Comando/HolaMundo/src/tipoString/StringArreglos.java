package tipoString;

public class StringArreglos {
    public static void main(String[] args) {
        String trabalenguas = "trabalenguas";
        System.out.println("trabalenguas.toCharArray() = " + trabalenguas.toCharArray());

        char[] arreglo = trabalenguas.toCharArray();
        for (int i=0; i < arreglo.length; i++) {
            System.out.println("arreglo[i] = " + arreglo[i]);
        }

        System.out.println("trabalenguas.split(\"a\") = " + trabalenguas.split("a") + "\n");

        String[] arreglo2 = trabalenguas.split("a");
        for (int i=0; i < arreglo2.length; i++) {
            System.out.println("arreglo2[i] = " + arreglo2[i]);
        }
    }
}
