package domain;

public class Profesor extends Persona {
    private String asignatura;

    public Profesor() {
        // super(); Implicito cuando se crea un constructor vacio - El hijo si o si tiene que t
        System.out.println("Profesor: Inicializando constructor");
    }

    public Profesor(String nombre, String apellido) {
        super(nombre, apellido);
    }

    public Profesor(String nombre, String apellido, String asignatura) {
        super(nombre, apellido);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public String saludar() {
        return "Hola que tal soy profesor";
    }
}
