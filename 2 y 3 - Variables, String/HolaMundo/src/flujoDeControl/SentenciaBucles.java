package flujoDeControl;

public class SentenciaBucles {
    public static void main(String[] args) {

        // FOR
        int total = 0;
        for(int i = 0; i <= 5; i++) {
            // continue; break;
            total += i;
        }
        System.out.println("total = " + total);

        String[] nomnbre = {"pepe", "diego", "lele"}; // Se puede poner tambien en nombre[]

        // WHILE
        int i = 0;
        while (i <= 5) {
            // DO SOMETHING
            i++;
        }

        // DO WHILE -> Execute 1 time
        int j = 0;
        do {
            j++;
        } while (j <= 5);

        // FOR EACH
        int[] numeros = {1, 3, 5, 7, 9, 11, 13, 14};
        for (int num : numeros) {
            System.out.println("num = " + num);
        }

        // FOR
        for(int k = 0; k < 5; k++) {
            // DO SOMETHING
        }

        bucle1: // Esto se llama ETIQUETA, cuando llega a 2 corta el bucle1.. es como asignar un nombre al for
        for (int h = 0; h < 5; h++) {
            if(h == 2) {
                // Si se pone continue; continua con el siguiente elemento y no sigue con el que estaba
                break bucle1;
            }
        }
    }
}
