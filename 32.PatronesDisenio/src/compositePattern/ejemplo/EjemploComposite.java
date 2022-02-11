package compositePattern.ejemplo;

import compositePattern.Archivo;
import compositePattern.Directorio;

public class EjemploComposite {
    public static void main(String[] args) {
        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));
        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx"));
        java.addComponente(stream);
        doc.addComponente(java);
        doc.addComponente(new Archivo("cd.docx"))
                .addComponente(new Archivo("logo.jpg"));

        System.out.println(doc.mostrar());
    }
}
