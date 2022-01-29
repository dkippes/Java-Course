public class EjemploAutomovil {
    public static void main(String[] args) {

        System.out.println("Auto sin atributos:");
        Automovil autoSinAtributos = new Automovil();

        System.out.println(autoSinAtributos.detalle());

        System.out.println("\nAuto con atributos:");
        Automovil mazda = new Automovil("Mazda", "MD-10");
        mazda.setColor("Rojo");
        mazda.setCilindrada(100.0);

        System.out.println(mazda.detalle());
        System.out.println(mazda.getFabricante());
        System.out.println(mazda.acelerar(3000));
        System.out.println(mazda.frenar());

        System.out.println(mazda.acelerarFrenar(5000));

        System.out.println("Kilometros por litro: " + mazda.calcularConsumo(300, 0.6f));
        System.out.println("Kilometros por litro: " + mazda.calcularConsumo(300, 60));

        /**** NISSAN ****/
        System.out.println("\nCreando Nissan:");
        Automovil nissan = new Automovil("Nissan", "GTR", "Gris");

        System.out.println(nissan.toString());

        System.out.println("son iguales Mazda == Nisan? " + (mazda == nissan) + " -> Tienen distintas referencias");
        System.out.println("son iguales Mazda.equals(Nisan)? " + (mazda.equals(nissan)) + " -> Si tienen los mismos atributos seria true");

        nissan.colorPatente = "Verde";
        System.out.println("Accediendo a un atributo estatico, se puede modificar en public pero no default y cambia para todos las instancias");
        System.out.println(nissan.toString());
        System.out.println(nissan.VELOCIDAD_MAXIMA_CARRETERA);
    }
}
