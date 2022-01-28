package wrapper;

class Persona {
    private String nombre;

    public void modificarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public String leerNombre() {
        return this.nombre;
    }
}

public class PasarArgumentoPorReferencia2 {
    public static void main(String[] args) {
        // Los arreglos son por referencia al igual que los objetos

        Persona persona = new Persona();
        persona.modificarNombre("Diego");

        System.out.println("iniciamos el metodo main");
        System.out.println("persona.nombre = " + persona.leerNombre());

        // llamamos al metodo test - este va a cambiar los valores
        System.out.println("Antes de llamar al metodo test");
        test(persona);
        System.out.println("Despues de llamar al metodo test");

        System.out.println("persona.leerNombre() despues del test = " + persona.leerNombre());

        System.out.println("Finaliza el metodo main");
    }

    public static void test(Persona persona) {
        System.out.println("iniciamos el metodo test");
        persona.modificarNombre("Pepe");
        System.out.println("Finaliza el metodo test");
    }
}
