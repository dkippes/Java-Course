import elementos.ElementoForm;
import elementos.InputForm;
import elementos.SelectForm;
import elementos.TextareaForm;
import elementos.select.Opcion;
import validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainForm {
    public static void main(String[] args) {

        /***************************************************/
        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador());

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());

        Opcion java = new Opcion("1", "Java");

        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "Javascript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected())
                .addOpcion(new Opcion("5", "PHP"));

        /**************** CLASE ANONIMA ***************/
        // No se puede usar en otro lado
        ElementoForm saludar = new ElementoForm() {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre +"' value=\"" + this.valor + "\">";
            }
        };

        saludar.setValor("Hola que tal este cambio esta desahabilitado");

        /*******************************/

        username.setValor("dkippes");
        password.setValor("1234678");
        email.setValor("kippes@gmail.com");
        edad.setValor("26");
        experiencia.setValor("1 año en backend");
        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje, saludar);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        /************** VALIDACION *****************/
        elementos.forEach(e -> {
            if(!e.esValido()){
                e.getErrores().forEach(System.err::println);
            }
        });
    }
}
