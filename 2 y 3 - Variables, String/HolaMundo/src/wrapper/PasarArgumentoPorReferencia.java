package wrapper;

public class PasarArgumentoPorReferencia {
    public static void main(String[] args) {
        // Los arreglos son por referencia al igual que los objetos

        int[] edad = { 10, 11, 12};

        System.out.println("iniciamos el metodo main");
        for(int i=0; i < edad.length; i++) {
            System.out.println("edad[i] = " + edad[i]);
        }

        // llamamos al metodo test - este va a cambiar los valores
        System.out.println("Antes de llamar al metodo test");
        test(edad);
        System.out.println("Despues de llamar al metodo test");
        for(int i=0; i < edad.length; i++) { // Apunta al mismo puntero de memoria - Se modifica
            System.out.println("edad[i] = " + edad[i]);
        }

        System.out.println("Finaliza el metodo main");
    }

    public static void test(int[] edadArr) {
        System.out.println("iniciamos el metodo test");
        for(int i=0; i < edadArr.length; i++) {
            edadArr[i] = edadArr[i] + 20;
        }
        System.out.println("Finaliza el metodo test");
    }
}
