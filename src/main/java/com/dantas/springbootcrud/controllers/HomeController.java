package com.dantas.springbootcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // define essa classe como um controlador MVC
public class HomeController {
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("nome","Dantas");
        return "home/index";
    }

}
