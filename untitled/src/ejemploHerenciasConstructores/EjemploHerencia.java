package ejemploHerenciasConstructores;

import domain.Alumno;
import domain.AlumnoInternacional;
import domain.Profesor;

public class EjemploHerencia {
    public static void main(String[] args) {
        System.out.println("============ CREANDO ALUMNO ============");
        Alumno alumno = new Alumno();
        alumno.setNombre("Diego");

        System.out.println("============ CREANDO ALUMNO INTERNACIONAL ============");
        AlumnoInternacional alumnoInternacional = new AlumnoInternacional();
        alumnoInternacional.setApellido("Kippes");
        alumnoInternacional.setPais("Argentina");

        System.out.println("============ CREANDO PROFESOR ============");
        Profesor profesor = new Profesor();
        profesor.setNombre("Lucho");
        profesor.setAsignatura("Matematica");

        System.out.println(alumno.getNombre() + " " + alumno.getApellido());
        System.out.println("Profesor " + profesor.getAsignatura()
                + ": " + profesor.getNombre()
                + ": " + profesor.getApellido());

        /***************** CLASS ********************/
        Class claseAlumnoInternacional = alumnoInternacional.getClass();
        while (claseAlumnoInternacional.getSuperclass() != null) {
            String hija = claseAlumnoInternacional.getName();
            String padre = claseAlumnoInternacional.getSuperclass().getName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            claseAlumnoInternacional = claseAlumnoInternacional.getSuperclass();
        }
    }
}
