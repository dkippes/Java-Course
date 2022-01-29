package tipoString;

public class StringInmutable {
    public static void main(String[] args) {
        // La instancia no se modifica, retorna una nueva instancia
        String curso = "Programacion Java";
        String profesor = "Andres";

        String resultado = curso.transform(c -> {
            return c.concat(" con " + profesor);
        });
        System.out.println("curso = " + curso); // No se modifica el curso
        System.out.println("resultado = " + resultado);
        
        String resultado2 = resultado.replace("a" , "A");
        System.out.println("resultado = " + resultado); // No cambio nada
        System.out.println("resultado2 = " + resultado2);
    }
}
