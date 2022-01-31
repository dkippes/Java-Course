public class EjemploAutomovilEnum {
    public static void main(String[] args) {
        System.out.println("\nCreando Nissan:");
        Automovil nissan = new Automovil("Nissan", "GTR", "Gris");

        System.out.println(nissan.toString());

        nissan.colorPatente = Color.BLANCO;
        System.out.println("\nAccediendo a un atributo estatico, se puede modificar en public pero no default y cambia para todos las instancias");
        System.out.println(nissan.VELOCIDAD_MAXIMA_CARRETERA);
        nissan.setTipo(TipoAutomovil.COUPE); // Poniendo Tipo
        System.out.println(nissan.toString());

        // Nuevo Switch
        switch (nissan.getTipo()) { // En java 13 se puede poner -> y el break es automatico
            case CONVERTIBLE -> System.out.println("Es convertible");
            case COUPE -> System.out.println("Es coupe");
            default -> System.out.println("No es nada");
        }

        // For
        TipoAutomovil[] tipos = TipoAutomovil.values();
        for (TipoAutomovil ta: tipos) {
            System.out.println("ta = " + ta.name()
                    + " | nombre: " + ta.getNombre()
                    + " | descripcion: " + ta.getDescripcion()
                    + " | puertas: " + ta.getNumeroPuerta());
            System.out.println();
        }
    }
}
