package flujoDeControl;

public class SentenciaBooleana {
    public static void main(String[] args) {
        if(true) {
            System.out.println("Es true");
        } else if(true) {
            System.out.println("Else if");
        } else {
            System.out.println("Else");
        }

        int num = 3;
        switch (num) { // Si no se pone el break continua
            case 0:
                System.out.println("Es 0");
                break;
            case 1:
                System.out.println("Es 1");
                break;
            case 2:
                System.out.println("Es 2");
                break;
            case 3:
                System.out.println("Es 3");
                break;
            default:
                System.out.println("No es ninguno");
        }
    }
}
