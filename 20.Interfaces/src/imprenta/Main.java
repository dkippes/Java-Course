package imprenta;

import imprenta.domain.*;

public class Main {
    public static void main(String[] args) {
        Curriculo cv = new Curriculo(new Persona("Diego", "Kippes"), "Lic Sistemas", "Resumen laboral");
        cv.addExperiencias("Java")
                .addExperiencias("Javascript");

        Libro libro = new Libro(new Persona("Eric", "Gamma"), "Patron de diseños: Elem. Reusables POO", Genero.PROGRAMACION);
        libro.addPagina(new Pagina("Patron Singleton"))
                .addPagina(new Pagina("Patron observador"))
                .addPagina(new Pagina("Patron factory"))
                .addPagina(new Pagina("Patron Composite"))
                .addPagina(new Pagina("Patron Facade"));

        Informe informe = new Informe(new Persona("Martin", "Fowler"), new Persona("James", "Gosling"), "Estudio microservicios");
        Imprimible.imprimir(cv);
        Imprimible.imprimir(informe);
        Imprimible.imprimir(libro);

        Imprimible.imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "Imprimiendo un objeto generico de una clase anonima";
            }
        });
    }


}
