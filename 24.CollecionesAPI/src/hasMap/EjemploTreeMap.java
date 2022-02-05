package hasMap;

import java.util.*;

public class EjemploTreeMap {
    public static void main(String[] args) {
        // TODO: No se pueden repetir llaves, va a ordenar las llaves
        // TODO: NO PUEDE EXISTIR NULLS
        Map<String, Object> persona = new TreeMap<>();
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@gmail.com");
        persona.put("edad", "30");

        Map<String, String> direcciones = new HashMap<>();
        direcciones.put("pais", "USA");
        direcciones.put("estados", "California");
        direcciones.put("calle", "Santa Barbara");

        persona.put("direccion", direcciones);

        System.out.println("persona = " + persona);
    }
}
