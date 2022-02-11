package decoratorPattern2;

public class Cafe implements Configurable {
    private float precio;
    private String nombre;

    public Cafe(String nombre, float precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    @Override
    public float getPrecioBase() {
        return this.precio;
    }

    @Override
    public String getIngredientes() {
        return this.nombre;
    }
}
