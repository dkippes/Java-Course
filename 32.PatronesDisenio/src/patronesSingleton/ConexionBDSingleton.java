package patronesSingleton;

public class ConexionBDSingleton {

    private static ConexionBDSingleton instancia;

    // Al hacer el constructor privado no se puede acceder con el new
    private ConexionBDSingleton() {
        System.out.println("Conectandose algun motor de base de datos");
    }

    public static ConexionBDSingleton getInstancia() {
        if(instancia == null) { // Siempre devuelve la misma instancia
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }
}
