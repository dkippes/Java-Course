package umlEjemplo;

public class Automovil {
    private int id;
    private String modelo;
    private String fabricante;
    private Color color = Color.GRIS;
    private Motor motor;
    private Estanque estanque;
    private Persona conductor;
    private Rueda[] ruedas;

    private TipoAutomovil tipo = TipoAutomovil.COUPE;

    private static Color colorPatente = Color.NARANJO;
    private static int capacidadEstanqueEstatico = 30;
    private static int ultimoId;

    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;
    public static final int VELOCIDAD_MAXIMA_CIUDAD = 60;

    public Automovil() {
        this.id = ++Automovil.ultimoId;
    }

    public Automovil(String modelo, String fabricante) {
        this(); // Llama al constructor sin parametros
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    public Automovil(String modelo, String fabricante, Color color) {
        this(modelo, fabricante);
        this.color = color;
    }

    public Automovil(String modelo, String fabricante, Color color, Motor motor) {
        this(modelo, fabricante, color);
        this.motor = motor;
    }

    public Automovil(String modelo, String fabricante, Color color, Motor motor, Estanque estanque) {
        this(modelo, fabricante, color, motor);
        this.estanque = estanque;
    }

    public Automovil(String modelo, String fabricante, Color color, Motor motor, Estanque estanque, Persona conductor, Rueda[] ruedas) {
        this(modelo, fabricante, color, motor, estanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }


    /********************************************* GETTERS *******************************************/
    public String getModelo() {
        return this.modelo;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public Color getColor() {
        return this.color;
    }

    public static Color getColorPatente() { // Parecido a GET de los atributos
        return colorPatente;
    }

    public TipoAutomovil getTipo() {
        return this.tipo;
    }

    public Automovil(Motor motor) {
        this.motor = motor;
    }

    public Estanque getEstanque() {
        return estanque;
    }

    /******************************************* SETTERS *******************************************/
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public static void setColorPatente(Color colorPatente) { // Parecido a GET de los atributos
        Automovil.colorPatente = colorPatente;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setEstanque(Estanque estanque) {
        this.estanque = estanque;
    }

    /******************************************* METODOS *******************************************/

    public String acelerar(int rpm) {
        return "el auto " + this.fabricante + " acelerando a " + rpm + " rpm";
    }

    public String frenar() {
        return this.fabricante + " " + this.modelo + " frenando!";
    }

    public String acelerarFrenar(int rpm) {
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    // Esto es sobrecarga de metodos, mismo nombre diferentes tipo en los metodos
    public float calcularConsumo(int km, float porcentajeBencina) {
        return km/(this.estanque.getCapacidad() * porcentajeBencina);
    }

    public float calcularConsumo(int km, int porcentajeBencina) {
        return km/(this.estanque.getCapacidad() * (porcentajeBencina/100f));
    }

//    public static float calcularConsumo(int km, int porcentajeBencina) {    NO PUEDO USARLO PORQUE NO DEBE TENER ATRIBUTOS DE LA CLASE DENTRO
//        return km/(this.capacidadEstanque * (porcentajeBencina/100f));      LO CORRECTO ES LLAMARLA COMO: Automovil.calcularConsumo();
//    }

    /******************************************* EQUALS *******************************************/
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(!(obj instanceof Automovil)) {
            return false;
        }
        Automovil a = (Automovil) obj;
        return (this.modelo != null && this.fabricante != null &&
                this.modelo.equals(a.getModelo()) && this.fabricante.equals(a.getFabricante()));
    }

    /***************************************** EQUALS *******************************************/
    @Override
    public String toString() {
        return "Automovil{" +
                "id='" + this.id + '\'' +
                "modelo='" + this.modelo + '\'' +
                ", fabricante='" + this.fabricante + '\'' +
                ", color='" + this.color + '\'' +
                ", cilindrada=" + this.motor.getCilindrada() +
                ", capacidadEstanque=" + this.estanque.getCapacidad() +
                ", colorPatente=" + colorPatente +
                ", tipo=" + this.tipo.getNombre() +
                '}';
    }
}
