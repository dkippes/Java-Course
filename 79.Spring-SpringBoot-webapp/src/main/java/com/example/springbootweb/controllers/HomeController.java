package com.example.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Se puede poner "forward:" Pero este no reinicia el request, se mantiene
        // return "redirect:/app/index";
        return "forward:/app/index";
    }

    @GetMapping("/google")
    public String google() {
        return "redirect:https://www.google.com";
    }
}
