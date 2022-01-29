public class EliminarUnElementoDelArray {
    public static void main(String[] args) {

        int[] a = { 2, 4, 6, 8, 10};
        int[] b = new int[a.length-1];
        System.arraycopy(a, 0, b, 0, b.length);

        for (int i = 0; i < b.length; i++) {
            System.out.println("b[i] = " + b[i]);
        }
    }
}
