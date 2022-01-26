package tipoString;

public class StringConcatenacion {
    public static void main(String[] args) {
        String curso = "Programacion Java";
        String profesor = "Andres";
        
        String detalle = curso + " con el instructor " + profesor;
        System.out.println("detalle = " + detalle);

        String detalle2 = curso.concat(" - ".concat(profesor)); // Retorna otra instancia
        System.out.println("detalle2 = " + detalle2);
    }
}
