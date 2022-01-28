package wrapper;

public class Wrapper {
    public static void main(String[] args) {
        Integer intObjeto = Integer.valueOf(32768); // Se llama boxing -> de int a objeto
        Integer intObject2 = 32768; // Autoboxing automaticamente lo transforma en el objeto

        Short shortObject = 32767;
        System.out.println("shortObject.byteValue() = " + shortObject.byteValue());

        // Con == compara por referencia, con equals por objeto

    }
}
