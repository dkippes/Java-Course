package com.example.springbootformulario.controllers;

import com.example.springbootformulario.editors.NombreMayusculaEditor;
import com.example.springbootformulario.editors.PaisPropertyEditor;
import com.example.springbootformulario.editors.RolesPropertyEditor;
import com.example.springbootformulario.models.domain.Pais;
import com.example.springbootformulario.models.domain.Role;
import com.example.springbootformulario.models.domain.Usuario;
import com.example.springbootformulario.services.PaisService;
import com.example.springbootformulario.services.RoleService;
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

    @Autowired
    private PaisService paisService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RolesPropertyEditor rolesEditor;

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setIdentificador("12.456.789-K");
        usuario.setHabilitar(true);
        usuario.setValorSecreto("Algun valor secreto...");
        usuario.setPais(new Pais(3, "CL", "Chile"));
        usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
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
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Role.class, "roles", rolesEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero() {
        return Arrays.asList("Hombre", "Mujer");
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return roleService.listar();
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString() {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap() {
        Map<String, String> paises = new HashMap<>();
        paises.put("ROLE_ADMIN", "Administrador");
        paises.put("ROLE_USER", "Usuario");
        paises.put("ROLE_MODERATOR", "Moderador");
        return paises;
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("España", "Mexico", "Chile", "Argentina", "Peru", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        Map<String, String> paises = new HashMap<>();
        paises.put("ES", "España");
        paises.put("MX", "Mexico");
        paises.put("CL", "Chile");
        paises.put("AR", "Argentina");
        paises.put("PE", "Perú");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");
        return paises;
    }

    @PostMapping("/form")
    public String procesar(@Valid /*@ModelAttribute('user')*/ Usuario usuario, BindingResult result, Model model
//                           @RequestParam(name = "username") String username,
//                           @RequestParam String password,
//                           @RequestParam String email
                           ) {
        //validador.validate(usuario, result);
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Resultado form");
            return "form";
        }

        return "redirect:/ver";
    }

    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
        if (usuario == null) {
            return "redirect:/form";
        }
        model.addAttribute("titulo", "Resultado form");
        status.setComplete(); // Mantiene todos los atributos que vienen null
        return "resultado";
    }
}
