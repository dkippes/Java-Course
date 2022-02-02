package imprenta.domain;

import java.util.ArrayList;
import java.util.List;

public class Curriculo extends Hoja implements Imprimible {
    private Persona persona;
    private String carrera;
    private List<String> experiencias;

    public Curriculo(Persona persona, String carrera, String contenido) {
        super(contenido);
        this.persona = persona;
        this.carrera = carrera;
        this.experiencias = new ArrayList<>();
    }

    public Curriculo addExperiencias(String experiencia) {
        this.experiencias.add(experiencia);
        return this;
    }

    @Override
    public String imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ");
        sb.append(persona)
                .append("\n")
                .append("Resumen: ").append(this.contenido).append("\n")
                .append("Profesion: ").append(this.carrera).append("\n")
                .append("Experiencias: ").append("\n");

        this.experiencias.forEach(e -> {
            sb.append("- ").append(e).append("\n");
        });

        return sb.toString();
    }
}
