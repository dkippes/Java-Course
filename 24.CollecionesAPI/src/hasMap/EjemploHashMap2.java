package hasMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap2 {
    public static void main(String[] args) {
        Map<String, Object> persona = new HashMap<>(); // No se pueden repetir llaves
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@gmail.com");
        persona.put("edad", 30);
        persona.put(null, "1234");

        Map<String, String> direcciones = new HashMap<>();
        direcciones.put("pais", "USA");
        direcciones.put("estados", "California");
        direcciones.put("calle", "Santa Barbara");

        persona.put("direccion", direcciones);

        System.out.println("persona = " + persona);

    }
}
