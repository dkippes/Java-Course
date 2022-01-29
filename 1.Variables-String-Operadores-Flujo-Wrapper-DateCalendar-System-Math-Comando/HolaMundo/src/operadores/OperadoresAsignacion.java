package operadores;

public class OperadoresAsignacion {
    public static void main(String[] args) {
        int i = 5;
        int j = i + 4;

        i += 2;
        i -= 5;
        j *= 3;

        String sqlString = "SELECT * FROM clientes AS c";
        sqlString += "WHERE c.nombre = Diego";
    }
}
