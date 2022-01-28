package wrapper;

public class Metadata {
    public static void main(String[] args) {
        String texto = "Hola que tal!";
        
        Class strClass = texto.getClass();
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getSimpleName() = " + strClass.getSimpleName());
        System.out.println("strClass.getPackageName() = " + strClass.getPackageName());
    }
}
