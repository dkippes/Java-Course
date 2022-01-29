public class EjemploArreglos {
    public static void main(String[] args) {

        int[] numeros = new int[4];

        numeros[0] = 1;
        numeros[1] = Integer.valueOf("2");
        numeros[2] = (int) 3L;
        numeros[3] = 4;
        //numeros[4] = 5; -> No se puede acceder mas de la cantidad maxima del arreglo
    }
}
