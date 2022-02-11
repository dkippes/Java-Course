package manejoArchivos.servicio;

import java.io.*;
import java.util.Scanner;

public class ArchivoServicio {
    public void crearArchivo(String nombre) {
        File archivo = new File(nombre);
        try { // Desde java 7
            // FileWriter: Por cada append va a ir al disco (NO ES OPTIMO)
            // El segundo parametro es para no crear el archivo de 0
            // Va una sola vez al disco
            BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, true));
            buffer.append("Hola que tal amigos\n")
                    .append("Aca escribiendo un archivo\n")
                    .append("Hasta luego lucas\n");
            buffer.close(); // -> Si se pone el buffer en try() adentro de los parentesis no hace falta hacer el close
            System.out.println("El archivo se ha creado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearArchivo2(String nombre) {
        File archivo = new File(nombre);
        //TODO: Nos permite hacer mas cosas que BufferWriter
        try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo, true))) { // Desde java 7
            // FileWriter: Por cada append va a ir al disco (NO ES OPTIMO)
            // El segundo parametro es para no crear el archivo de 0
            // Va una sola vez al disco
            buffer.println("Hola que tal amigos");
            buffer.println("Aca escribiendo un archivo");
            buffer.printf("Hasta luego %s", "Diego!");
            // buffer.close(); -> Si se pone el buffer en try() adentro de los parentesis no hace falta hacer el close
            System.out.println("El archivo se ha creado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String leerArchivo(String nombre) {
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nombre));
            String linea;
            while ( (linea = reader.readLine()) != null ) {
                sb.append(linea)
                        .append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String leerArchivo2(String nombre) {
        StringBuilder sb = new StringBuilder();
        File archivo = new File(nombre);
        try (Scanner s = new Scanner(archivo)) {
            s.useDelimiter("\n");
            while ( s.hasNext() ) {
                sb.append(s.next())
                        .append("\n");
            }
            //s.close(); -> No hace falta que vaya si se instancia dentro de los ()
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
