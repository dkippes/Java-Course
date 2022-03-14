package com.example.springbootformulario.controllers;

import com.example.springbootformulario.editors.NombreMayusculaEditor;
import com.example.springbootformulario.models.domain.Usuario;
import com.example.springbootformulario.validation.UsuarioValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@SessionAttributes("usuario") // Cuando algun attribute viene en null desde form
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("123.456.789-K");
        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Es si es estricto o tolerante, false es estricto
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Peru", "Colombia", "Venezuela");
    }

    @PostMapping("/form")
    public String procesar(@Valid /*@ModelAttribute('user')*/ Usuario usuario, BindingResult result, Model model, SessionStatus status
//                           @RequestParam(name = "username") String username,
//                           @RequestParam String password,
//                           @RequestParam String email
                           ) {
        //validador.validate(usuario, result);
        model.addAttribute("titulo", "Resultado form");
        if (result.hasErrors()) {

            return "form";
        }

        model.addAttribute("usuario", usuario);
        status.setComplete(); // Mantiene todos los atributos que vienen null
        return "resultado";
    }
}
