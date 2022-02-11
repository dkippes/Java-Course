package decoratorPattern2.ejemplo;

import decoratorPattern2.Cafe;
import decoratorPattern2.Configurable;
import decoratorPattern2.decorador.ConChocolateDecorador;
import decoratorPattern2.decorador.ConCremaDecorador;
import decoratorPattern2.decorador.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {
        Configurable cafe = new Cafe("Cafe Mocha", 7);
        ConCremaDecorador conCrema = new ConCremaDecorador(cafe);
        ConLecheDecorador conLeche = new ConLecheDecorador(cafe);
        ConChocolateDecorador conChocolate = new ConChocolateDecorador(cafe);

        System.out.println("El precio del cafe mocha es: " + conChocolate.getPrecioBase());
        System.out.println("Los ingredientes: : " + conChocolate.getIngredientes());

        Configurable capuchino = new Cafe("Cafe Capuchino", 4);
        conCrema = new ConCremaDecorador(capuchino);
        conLeche = new ConLecheDecorador(conCrema);

        System.out.println("El precio del capuchino es: " + conLeche.getPrecioBase());
        System.out.println("Los ingredientes: : " + conLeche.getIngredientes());

        Configurable espresso = new Cafe("Cafe Espresso", 3);

        System.out.println("El precio del cafe espresso es: " + espresso.getPrecioBase());
        System.out.println("Los ingredientes: : " + espresso.getIngredientes());
    }
}
