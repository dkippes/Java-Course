package com.example.springbootformulario.models.domain;

import com.example.springbootformulario.validation.IdentificadorRegex;
import com.example.springbootformulario.validation.Requerido;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class Usuario {
    //@Pattern(regexp = "[0-9]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")
    @IdentificadorRegex
    private String identificador;

    //@NotEmpty(message = "El nombre no puede ser vacio")
    private String nombre;

    //@NotEmpty
    @Requerido
    private String apellido;

    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NotNull // Solo para objetos, no pritivivos
    @Min(1)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    @Past // -> Fecha en pasado
//    @Future //-> Fecha en futuro
//    @DateTimeFormat(pattern = "yyyy-MM-dd") -> HTML lo manda como yyyy-MM-dd, si pongo / falla
    private Date fechaNacimiento;

    @NotEmpty
    private String pais;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
