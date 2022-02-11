package decoratorPattern.decorador;

import decoratorPattern.Formateable;

abstract public class TextoDecorador implements Formateable {
    protected Formateable texto;

    public TextoDecorador(Formateable texto) {
        this.texto = texto;
    }
}
