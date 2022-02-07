package lambda;

import lambda.modelo.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        // TODO: Siempre retorna un boolean
        Predicate<Integer> test = num -> num > 10;
        System.out.println(test.test(7));

        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(t2.test("ROLE_USER"));

        BiPredicate<String, String> t3 = String::equals;
        System.out.println(t3.test("Diego", "Juan"));

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("maria");
        b.setNombre("pepe");
        BiPredicate<Usuario, Usuario> t5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a, b));
    }
}
