package umlEjemplo;

public class EjemploAutomovil {
    public static void main(String[] args) {
        Motor motor = new Motor(40, TipoMotor.BENCINA);
        Color color = Color.AZUL;
        Estanque estanque = new Estanque(60);
        Persona persona = new Persona("Diego", "Kippes");
        Rueda rueda = new Rueda("Brig", 30, 30);
        Rueda[] ruedas = { rueda, rueda, rueda, rueda };
        Automovil mazda = new Automovil("MD-10", "Mazda", color, motor, estanque, persona, ruedas);
        System.out.println(mazda.toString());
    }
}
