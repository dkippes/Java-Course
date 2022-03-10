package jaxRs.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructores")
public class Intructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"instructor", "handler", "hibernateLazyInitializer"}) // Estos atributos pueden generar problemas de recursividad
    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL) // Establece la relacion inversa con su contraparte
    private List<Curso> cursos;

    private String nombre;
    private String apellido;

    public Intructor() {
        this.cursos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
