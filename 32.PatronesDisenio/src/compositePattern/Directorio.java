package compositePattern;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente {
    private List<Componente> hijos;

    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    public Directorio addComponente(Componente c) {
        this.hijos.add(c);
        return this;
    }

    public void removeComponente(Componente c) {
        this.hijos.remove(c);
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre)
                .append("/")
                .append("\n");

        for (Componente c: this.hijos) {
            sb.append(mostrar())
                    .append("\n");
        }

        return sb.toString();
    }
}
