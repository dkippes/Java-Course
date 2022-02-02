package imprenta.domain;

public interface Imprimible {
    String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";

    default String imprimir() { // Las clases que lo implementen no van a estar obligadas a implementarlo
        return TEXTO_DEFECTO;
    }

    static void imprimir(Imprimible imprimible) {
        System.out.println(imprimible.imprimir());
    }
}
