package com.example.springbootcrudjpa.controllers;

import com.example.springbootcrudjpa.models.entity.Cliente;
import com.example.springbootcrudjpa.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", service.findAll());
        return "listar";
    }

    @GetMapping("/form")
    public String crear(Map<String, Object> model) {
        Cliente cliente = new Cliente();
        model.put("cliente", cliente);
        model.put("titulo", "Formulario de cliente");
        return "form";
    }

    @PostMapping("/form")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
        if (result.hasErrors()) {
            // El cliente se pasa de forma automatica si se llama igual
            model.addAttribute("titulo", "Formulario de cliente");
            return "form";
        }
        String mensajeFlash = (cliente.getId() != null) ? "Cliente editado con exito" : "Cliente creado con exito!";
        service.save(cliente);
        status.setComplete();
        flash.addAttribute("success", "Cliente Creado con exito!");
        return "redirect:listar";
    }

    @GetMapping("/form/{id}")
    public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash ) {
        Cliente cliente = null;
        if (id > 0) {
            cliente = service.findOne(id);
            if (cliente == null) {
                flash.addAttribute("error", "El ID del cliente debe existir en la base de datos");
                return "redirect:/listar";
            }
        } else {
            flash.addAttribute("error", "El ID del cliente no puede ser 0");
            return "redirect:/listar";
        }
        model.put("cliente", cliente);
        model.put("titulo", "Editar cliente");
        return "form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            service.delete(id);
        }
        return "redirect:/listar";
    }
}
