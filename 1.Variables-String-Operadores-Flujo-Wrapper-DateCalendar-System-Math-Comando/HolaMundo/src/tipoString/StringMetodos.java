package tipoString;

public class StringMetodos {
    public static void main(String[] args) {
        String nombre = "Diego";

        System.out.println("nombre.length() = " + nombre.length());
        System.out.println("nombre.toUpperCase() = " + nombre.toUpperCase());
        System.out.println("nombre.toLowerCase() = " + nombre.toLowerCase());
        System.out.println("nombre.equals(\"Diego\") = " + nombre.equals("Diego"));
        System.out.println("nombre.equals(\"diego\") = " + nombre.equals("diego"));
        System.out.println("nombre.equalsIgnoreCase(\"diego\") = " + nombre.equalsIgnoreCase("diego"));
        System.out.println("nombre.compareTo(\"Diego\") = " + nombre.compareTo("Diego"));
        System.out.println("nombre.compareTo(\"Aaron\") = " + nombre.compareTo("Aaron"));
        System.out.println("nombre.compareTo(\"Zoe\") = " + nombre.compareTo("Zoe"));
        System.out.println("nombre.charAt(3) = " + nombre.charAt(3)); // Si me paso tira out of range
        System.out.println("nombre.charAt(nombre.length()-1) = " + nombre.charAt(nombre.length() - 1));
        System.out.println("nombre.substring(2) = " + nombre.substring(2));
        System.out.println("nombre.substring(2, 4) = " + nombre.substring(2, 4));
        
        String trabaLenguas = "trabalenguas";
        System.out.println("\ntrabaLenguas.replace(\"a\", \".\") = " + trabaLenguas.replace("a", ".")); // El original no se cambia
        System.out.println("trabaLenguas.indexOf(\"a\") = " + trabaLenguas.indexOf("a"));
        System.out.println("trabaLenguas.lastIndexOf(\"a\") = " + trabaLenguas.lastIndexOf("a"));
        System.out.println("trabaLenguas.indexOf(\"z\") = " + trabaLenguas.indexOf("z"));
        System.out.println("trabaLenguas.lastIndexOf(\"z\") = " + trabaLenguas.lastIndexOf("z"));
        System.out.println("trabaLenguas.contains(\"engu\") = " + trabaLenguas.contains("engu"));
        System.out.println("trabaLenguas.contains(\"z\") = " + trabaLenguas.contains("z"));
        System.out.println("trabaLenguas.startsWith(\"tr\") = " + trabaLenguas.startsWith("tr"));
        System.out.println("trabaLenguas.endsWith(\"s\") = " + trabaLenguas.endsWith("s"));
        System.out.println("   trabalenguas   ".trim());
    }
}
