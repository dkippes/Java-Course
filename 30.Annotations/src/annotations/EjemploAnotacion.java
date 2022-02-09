package annotations;

import annotations.models.Producto;
import annotations.procesador.JsonSerializador;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {
        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa centro ROBLE");
        p.setPrecio(1000L);

        System.out.println("JsonSerializador.convertirJson(p) = " + JsonSerializador.convertirJson(p));
    }
}
