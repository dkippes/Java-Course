package hasMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {
    public static void main(String[] args) {
        Map<String, String> persona = new HashMap<>(); // No se pueden repetir llaves
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "john.doe@gmail.com");
        persona.put("edad", "30");
        persona.put(null, "1234");

        System.out.println("persona = " + persona);
        System.out.println("persona.get(\"apellido\") = " + persona.get("apellido"));

        String valorApellido = persona.remove("apellidoPaterno"); // TODO: persona.remove("apellidoPaterno", "Roe"); -> boolean
        System.out.println("valorApellido = " + valorApellido);
        System.out.println("persona = " + persona);

        System.out.println("persona.containsKey(\"email\") = " + persona.containsKey("email"));
        System.out.println("persona.containsValue(\"1234\") = " + persona.containsValue("1234"));

        System.out.println("\nObteniendo valores");
        Collection<String> values = persona.values();
        for (String v : values) {
            System.out.println("v = " + v);
        }

        System.out.println("\nObteniendo llaves");
        Set<String> llaves = persona.keySet();
        for (String l : llaves) {
            System.out.println("l = " + l);
        }

        System.out.println("\nIterando llaves y valor");
        for (Map.Entry<String, String> par: persona.entrySet()) {
            System.out.println(par.getKey() + " => " + par.getValue());
        }

        System.out.println("\nIterando llaves y valor 2");
        for (String llave : persona.keySet()) {
            String valor = persona.get(llave);
            System.out.println(llave + " -> " + valor);
        }

        System.out.println("\nIterando llaves y valor 3: Con java 8");
        persona.forEach((llave, valor) -> {
            System.out.println(llave + " --> " + valor);
        });

        System.out.println("\nRemplazando");
        System.out.println("persona.replace(\"nombre\", \"Juan\", \"Andres\") = " + persona.replace("nombre", "Juan", "Andres"));
    }
}
