package annotations.procesador;

import annotations.Init;
import annotations.JsonAtributo;
import annotations.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {

    public static void inicializarObjeto(Object o) {
        if (Objects.isNull(o)) {
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }

        Method[] metodos = o.getClass().getDeclaredMethods();
        Arrays.stream(metodos)
                .filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true);
                    try {
                        m.invoke(o);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se puede iniciar el objeto");
                    }
                });


    }

    public static String convertirJson(Object o) {
        if (Objects.isNull(o)) {
            throw new JsonSerializadorException("El objeto a serializar no puede ser null");
        }
        inicializarObjeto(o);
        Field[] atributos = o.getClass().getDeclaredFields();

        return Arrays.stream(atributos)
                .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
                .map(f -> {
                    f.setAccessible(true); // Aunque los campos sean privados nos deja acceder
                    String nombre = f.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? f.getName()
                            : f.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = f.get(o);
                        if (f.getAnnotation(JsonAtributo.class).capitalizar() &&
                                valor instanceof String) {
                            String nuevoValor = (String) valor;
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0, 1).toUpperCase()
                                            + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));

                            f.set(o, nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + f.get(o) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar a json: " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    if ("{" .equals(a)) {
                        return a + b;
                    }
                    return a + ", " + b;
                })
                .concat("}");
    }
}
