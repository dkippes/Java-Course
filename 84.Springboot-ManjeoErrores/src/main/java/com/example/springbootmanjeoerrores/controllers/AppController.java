package com.example.springbootmanjeoerrores.controllers;

import com.example.springbootmanjeoerrores.errors.UsuarioNoEncontradoException;
import com.example.springbootmanjeoerrores.models.domain.Usuario;
import com.example.springbootmanjeoerrores.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/index")
    public String index() {
//        Integer valor = 100/0;
        Integer valor = Integer.parseInt("10xaaa");
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {
//        Usuario usuario = service.obtenerPorId(id);
//        if (usuario == null) {
//            throw new UsuarioNoEncontradoException(id.toString());
//        }
        Usuario usuario = service.obtenerPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
        return "ver";
    }
}
