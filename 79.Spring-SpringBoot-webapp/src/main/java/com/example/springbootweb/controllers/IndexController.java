package com.example.springbootweb.controllers;

import com.example.springbootweb.models.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/app")
public class IndexController {
    @Value("${texto.indexController.index.titulo}")
    private String textoIndex;
    @Value("${texto.indexController.index.perfil}")
    private String textoPerfil;
    @Value("${texto.indexController.index.listar}")
    private String textoListar;

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Diego");
        usuario.setApellido("Kippes");
        usuario.setEmail("kippes@gmail.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
        return "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> asignarUsuarios() {
        return Arrays.asList(
                new Usuario("lola", "perez", "lola@gmail.com"),
                new Usuario("pepa", "hio", "pepa@gmail.com"),
                new Usuario("mauricio", "joa", "mauricio@gmail.com"));
    }
}
