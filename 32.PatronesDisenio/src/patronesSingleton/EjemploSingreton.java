package patronesSingleton;

public class EjemploSingreton {
    public static void main(String[] args) {
    //Patron Singleton: Se usa una sola instancia a lo ancho de la app
        for (int i=0; i < 10; i++) {
            ConexionBDSingleton con = ConexionBDSingleton.getInstancia();
            System.out.println("con = " + con);
        }
    }
}
