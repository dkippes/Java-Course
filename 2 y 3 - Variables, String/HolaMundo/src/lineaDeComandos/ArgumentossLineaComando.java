package lineaDeComandos;

public class ArgumentossLineaComando {
    public static void main(String[] args) {
        // Entrando a la carpeta y a este archivo por terminal ejecutando; javac ArgumentossLineaComando.java
        // genera el bytecode que es el archivo que lee java y lo crea en el "out" terminan con .class
        // Bytecode es el lenguaje intermedio entre 0-1 y el humano, javac es el compilador de java

        // Para ejecutar el archivo: java ArgumentossLineaComando.java "Pepe" "Agustin" "Diego Kippes"
        // va a tener 3 argumentos que se pasan de la terminal al archivo (seria el args)

        if(args.length == 0) {
            System.out.println("Debe ingresar argumentoss!");
            System.out.println("Podemos generar nuestro propio bytecode manualmente y que lea acentos: javac ArgumentossLineaComando.java -encoding utf8");
            System.out.println("Ingresa en la terminal: java ArgumentossLineaComando.java \"Pepe\" \"Agustin\" \"Diego Kippes\"");
            System.exit(-1); // Tiramos un error
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argumentos n " + i + ": " + args[i]);
        }
    }
}
