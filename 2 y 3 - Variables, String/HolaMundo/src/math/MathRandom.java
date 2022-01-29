package math;

import java.util.Random;

public class MathRandom {
    public static void main(String[] args) {
        double random = Math.random();
        System.out.println("random = " + random); // El 1 se excluye
        random *= 7; // de 0 a 7, sin incluir el 7
        System.out.println("random a 7 = " + random);

        /********* EJEMPLO *****************/
        String[] colores = {"azul", "amarillo", "rojo", "verde", "blanco", "negro"};
        double randomColores = Math.random();
        random *= colores.length;

        System.out.println("colores = " + colores[(int) randomColores]);


        /*** EJEMPLO CLASE RANDOM ***/
        Random randomObj = new Random();
        int randomInt = randomObj.nextInt(7); // 0 y 7 pero no se incluye el 7
        System.out.println("randomInt = " + randomInt);

        System.out.println("randomObt pero con colores = " + colores[randomObj.nextInt(colores.length)]);
    }
}
