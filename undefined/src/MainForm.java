import elementos.ElementoForm;
import elementos.InputForm;
import elementos.SelectForm;
import elementos.TextareaForm;
import elementos.select.Opcion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainForm {
    public static void main(String[] args) {

        /**************** CLASE ANONIMA ***************/
        // No se puede usar en otro lado
        ElementoForm el = new ElementoForm() {
            @Override
            public String dibujarHtml() {
                return null;
            }
        };

        /***************************************************/
        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");

        TextareaForm experiencia = new TextareaForm("exp", 5, 9);
        SelectForm lenguaje = new SelectForm("lenguaje");
        Opcion java = new Opcion("1", "Java");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "Javascript"))
                .addOpcion(new Opcion("4", "TypeScript"))
                .addOpcion(new Opcion("5", "PHP"));

        username.setValor("dkippes");
        password.setValor("1234");
        email.setValor("kippes@gmail.com");
        edad.setValor("26");
        experiencia.setValor("1 año en backend");
        java.setSelected(true);

        List<ElementoForm> elementos = Arrays.asList(username, password, email, edad, experiencia, lenguaje);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });
    }
}
