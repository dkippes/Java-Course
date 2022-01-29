package claseSystemPropiedades;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploAsignarPropiedadesDeSistemas {
    public static void main(String[] args) {
        try {
            FileInputStream archivo = new FileInputStream("src/claseSystemPropiedades/config.properties");

            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada", "Mi valor guardado en el objeto properties");

            System.setProperties(p); // Se lo pasamos para que actualize las propiedades del sistema
            System.getProperties().list(System.out);

            // Obtener una sola propiedad
            System.out.println("\n" + System.getProperty("config.autor.email"));

        } catch (IOException e) {
            System.err.println("No existe el archivo = " + e); // Podemos escribir System.err
            System.exit(1); // Con exit(1) se termina
        }
    }
}
