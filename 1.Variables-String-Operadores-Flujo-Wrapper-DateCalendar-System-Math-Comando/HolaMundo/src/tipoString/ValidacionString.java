package tipoString;

public class ValidacionString {
    public static void main(String[] args) {
        String curso = null;

        boolean esNulo = curso == null;
        System.out.println("esNulo = " + esNulo);

        if(esNulo) {
            curso = "";
        }
        
        boolean esVacio = curso.length() == 0;
        System.out.println("esVacio = " + esVacio);
        
        boolean esEmpty = curso.isEmpty();
        System.out.println("esEmpty = " + esEmpty);
        
        curso = " ";
        boolean esBlanco = curso.isBlank();
        System.out.println("esBlanco = " + esBlanco);
    }
}
