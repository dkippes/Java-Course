package ejemplo;

public class DivisionPorZeroException extends Exception { // Si ponemos que sea de RunTime no nos obliga a lanza la exp
    public DivisionPorZeroException(String message) {
        super(message);
    }
}
