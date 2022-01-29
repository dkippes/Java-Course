package claseSystemPropiedades;

import java.util.Map;

public class VariablesDeEntorno {
    public static void main(String[] args) {
        // si nos vamos a variables de entorno del sistema podemos agregar nuestras variables de ambiente
        // Para agregar variables de entorno: Propiedades de sistema -> variables de entorno
        Map<String, String> varEnv = System.getenv();
        System.out.println("variables de ambiente del sistema = " + varEnv);

        String username = System.getenv("USERNAME"); // Podemos obtenerlo asi
        System.out.println("username = " + username);
        
        String path = varEnv.get("Path"); // Podemos obtenerlo asi
        System.out.println("Path = " + path);
        
        String appEnvAgregadoPorMi = varEnv.get("APPLICATION_TEST");
        System.out.println("appEnvAgregadoPorMi = " + appEnvAgregadoPorMi);

        String saludarHola = varEnv.get("SALUDAR_HOLA");
        System.out.println("saludarHola = " + saludarHola);

        // PARA WINDOWS EN TERMINAL -> setx SALUDAR_HOLA "Hola amigos"
        // PARA LINUX/MAC -> EXPORT ..
    }
}
