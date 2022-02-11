package manejoArchivos;

import manejoArchivos.servicio.ArchivoServicio;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "D:\\Master Completo en Java\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        System.out.println(service.leerArchivo(nombreArchivo));
    }
}
