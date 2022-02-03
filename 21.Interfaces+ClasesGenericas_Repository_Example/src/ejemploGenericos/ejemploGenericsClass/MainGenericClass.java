package ejemploGenericos.ejemploGenericsClass;

public class MainGenericClass {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinarias = new Camion(3);
        transMaquinarias.add(new Maquinaria("Bulldozer"));
        transMaquinarias.add(new Maquinaria("Grua Horquilla"));
        transMaquinarias.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinarias);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
    }

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T o: camion) {
            if (o instanceof Animal) {
                System.out.println(((Animal)o).getNombre() + " tipo: " + ((Animal)o).getTipo());
            }
            if (o instanceof Automovil) {
                System.out.println(((Automovil)o).getMarca());
            }
            if (o instanceof Maquinaria) {
                System.out.println(((Maquinaria)o).getTipo());
            }
        }
    }
}
