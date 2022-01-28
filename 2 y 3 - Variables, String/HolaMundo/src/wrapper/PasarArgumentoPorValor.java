package wrapper;

public class PasarArgumentoPorValor {
    public static void main(String[] args) {
        Integer i = 10;

        System.out.println("iniciamos el metodo main con i = " + i);
        test(1);
        System.out.println("Finaliza el metodo main con i = " + i);
        // i no cambia porque las clases Integer, Short, String.. etc son inmutables no pueden cambiar
    }

    public static void test(Integer i) {
        System.out.println("iniciamos el metodo main con i = " + i);
        i = 35;
        System.out.println("Finaliza el metodo main con i = " + i);
    }
}
