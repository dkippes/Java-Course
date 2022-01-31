// Una clase solo puede ser public o default (sin), no privada
public class Automovil implements Comparable<Automovil> {
    // Si un atributo es estatico puede ser compartido para todos los objetos
    private int id;
    private String modelo;
    private String fabricante;
    private String color = "Azul";
    private double cilindrada;
    private int capacidadEstanque = 40;

    private TipoAutomovil tipo = TipoAutomovil.SEDAN;

    /*************************** ATRIBUTO STATICO -> PERTENECE A LA CLASE ES PARA TODAS LAS INSTANCIAS **************/
    static Color colorPatente = Color.AMARILLO; // Por default es public, si se pone privado solo se podria usar/modificar en la clase
    private static int ultimoId;

    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;



    /******************************************* CONSTRUCTORES *******************************************/
    public Automovil() {
        this.id = ++Automovil.ultimoId;
    }

    public Automovil(String modelo, String fabricante) {
        this(); // Llama al constructor sin parametros
        this.modelo = modelo;
        this.fabricante = fabricante;
    }

    public Automovil(String modelo, String fabricante, String color) {
        this(modelo, fabricante); // Se puede reutilizar llamando al otro Constructor
        this.color = color;
    }

    /********************************************* GETTERS *******************************************/
    public String getModelo() {
        return this.modelo;
    }

    public String getFabricante() {
        return this.fabricante;
    }

    public String getColor() {
        return this.color;
    }

    public double getCilintrada() {
        return this.cilindrada;
    }

    public int getCapacidadEstanque() {
        return this.capacidadEstanque;
    }

    public static Color getColorPatente() { // Parecido a GET de los atributos
        return colorPatente;
    }

    public TipoAutomovil getTipo() {
        return this.tipo;
    }

    /******************************************* SETTERS *******************************************/
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setCapacidadEstanque(int capacidadEstanque) {
        this.capacidadEstanque = capacidadEstanque;
    }

    public static void setColorPatente(Color colorPatente) { // Parecido a GET de los atributos
        Automovil.colorPatente = colorPatente;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    /******************************************* METODOS *******************************************/
    public String detalle() {
        StringBuilder sb = new StringBuilder();
        sb.append("auto.fabricante = " + this.fabricante + "\n");
        sb.append("auto.modelo = " + this.modelo + "\n");
        sb.append("auto.color = " + this.color + "\n");
        sb.append("auto.cilindrada = " + this.cilindrada + "\n");
        return sb.toString();
    }

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
        return km/(this.capacidadEstanque * porcentajeBencina);
    }

    public float calcularConsumo(int km, int porcentajeBencina) {
        return km/(this.capacidadEstanque * (porcentajeBencina/100f));
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
                ", cilindrada=" + this.cilindrada +
                ", capacidadEstanque=" + this.capacidadEstanque +
                ", colorPatente=" + colorPatente +
                ", tipo=" + this.tipo.getNombre() +
                '}';
    }

    @Override
    public int compareTo(Automovil a) {
        return this.fabricante.compareTo(a.fabricante);
    }
}
