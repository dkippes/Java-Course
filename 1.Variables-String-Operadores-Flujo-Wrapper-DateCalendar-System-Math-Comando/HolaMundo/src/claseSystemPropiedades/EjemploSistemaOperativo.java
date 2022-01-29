package claseSystemPropiedades;

import java.io.IOException;

public class EjemploSistemaOperativo {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime(); // Instancia del tiempo de ejecucion - Para poder ejecutar algo de nuestra maquina
        Process proceso;


        try {
            if(System.getProperty("os.name").contains("Windows")) {
                proceso = rt.exec("notepad"); // Ejecuta el notepad
            } else {
                proceso = rt.exec("gedit"); // Ejecuta notepad para linux/mac
            }
            proceso.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
