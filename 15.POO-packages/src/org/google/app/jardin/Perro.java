package org.google.app.jardin;

import org.google.app.hogar.Persona;

public class Perro { // Si se saca el public no se puede acceder fuera del package
    protected String nombre;
    protected String raza; // Funciona igual que default protected

    public String jugar(Persona persona) {
        return persona.lanzarPelota();
    }
}
