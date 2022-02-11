package observer.ejemplo;

import observer.Corporacion;
import observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        repo.addObserver((observable, u) -> System.out.println("Enviando un email al usuario: " + u));
        repo.addObserver((observable, u) -> System.out.println("Enviando un email al administrador: " + u));
        repo.addObserver((observable, u) -> System.out.println("Guardando info del usuario en el logs: "  + u));
        repo.crearUsuario("Diego");
    }
}
