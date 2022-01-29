package org.google.app;

import org.google.app.hogar.Persona;
import org.google.app.jardin.Perro;

import static org.google.app.hogar.Persona.saludar;

public class TestMain {
    public static void main(String[] args) {
        Persona p = new Persona();
        Perro pe = new Perro();

        String jugando = pe.jugar(p); // Si el metodo fuera default no podria usarse fuera del package jardin
        System.out.println("jugando = " + jugando);

        System.out.println(saludar());
    }
}
