package matrices;

public class EjemploMatrices {
    public static void main(String[] args) {
        int[][] numeros = new int[2][4];

        numeros[0][0] = 1;
        numeros[0][1] = 2;
        numeros[0][2] = 3;
        numeros[0][3] = 4;
        numeros[1][0] = 5;
        numeros[1][1] = 6;
        numeros[1][2] = 7;
        numeros[1][3] = 8;

        System.out.println("numero de filas: " + numeros.length);
        System.out.println("numero de columnas: " + numeros[0].length);

        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                System.out.println("matriz[" + i + "][" + j + "]: " + numeros[i][j]);
            }
        }

        /* FOR EACH -> CON ELEMENTO A BUSCAR */
        int elementoBuscar = 9;
        boolean encontrado = false;
        int[][] numeros2 = {
                {7, 8, 9, 1},
                {5, 6, 8, 3}
        };
        System.out.println("\nCon for each");
        buscar: for (int[] fila: numeros2) {
            for (int numero: fila) {
                System.out.println(numero);
                if(numero == elementoBuscar) {
                    encontrado = true;
                    break buscar;
                }
            }
        }

        if(encontrado) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}

