package decoratorPattern.ejemplo;

import decoratorPattern.Formateable;
import decoratorPattern.Texto;
import decoratorPattern.decorador.MayusculaDecorador;
import decoratorPattern.decorador.RemplazarEspacioDecorador;
import decoratorPattern.decorador.ReversaDecorador;
import decoratorPattern.decorador.SubrayadoDecorador;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Diego");

        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        // ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayado = new SubrayadoDecorador(mayuscula);
        RemplazarEspacioDecorador remplazar = new RemplazarEspacioDecorador(subrayado);

        System.out.println(remplazar.darFormato());
    }
}
