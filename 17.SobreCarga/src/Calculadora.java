public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public float sumar(float x, float y) {
        return x + y;
    }

    public float sumar(int x, float y) {
        return x + y;
    }

    public int sumar(String x, String y) {
        int resultado;
        try {
            resultado = Integer.parseInt(x) + Integer.parseInt(y);
        } catch (NumberFormatException e) {
            resultado = 0;
            System.out.println(e);
        }
        return resultado;
    }

    public int sumar(int x, int y, int z) {
        return x + y + z;
    }

    public int sumar(int... argumentos) {
        int total = 0;
        for (int i : argumentos) {
            total += i;
        }
        return total;
    }

}
