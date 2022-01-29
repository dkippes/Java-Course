package lineaDeComandos;

public class ArgumentosLineaComandoCalculadora {
    public static void main(String[] args) {

        // Para pasar argumentos desde el IDE = Seleccionar ArgumentosListaComandoCalculadora -> editar configuracion
        // Colocar los argumentos por espacio donde dice Program Argumentos: suma 5 3

        if(args.length != 3) {
            System.err.println("Por favor ingresar una operacion (suma, resta, multi, div) y 2 enteros");
            System.exit(-1);
        }

        String operacion = args[0];
        int a = 0;
        int b = 0;
        double resultado = 0.00;

        try {
            a = Integer.parseInt(args[1]);
            b = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Cuidado a y b deben ser enteros");
            System.exit(-1);
        }

        switch (operacion) {
            case "suma":
                resultado = a+b;
                break;
            case "resta":
                resultado = a-b;
                break;
            case "multi":
                resultado = a*b;
                break;
            case "div":
                if(b == 0) {
                    System.err.println("No se puede dividir por 0");
                    System.exit(-1);
                }
                resultado = (double) a/b;
                break;
            default:
                System.out.println("No se ingreso ningun caso");
                System.exit(1);
        }

        System.out.println("Resultado de la operacion " + operacion + " es: " + resultado);
    }
}
