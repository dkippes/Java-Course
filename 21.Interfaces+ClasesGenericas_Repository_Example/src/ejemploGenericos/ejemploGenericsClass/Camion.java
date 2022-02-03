package ejemploGenericos.ejemploGenericsClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T> {
    private List<T> objetos;
    private int max;

    public Camion(int max) {
        this.objetos = new ArrayList<>();
        this.max = max;
    }

    public void add(T object) {
        if(this.objetos.size() <= this.max){
            this.objetos.add(object);
        } else {
            throw new RuntimeException("no hay mas espacio");
        }

    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
