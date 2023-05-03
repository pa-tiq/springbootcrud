package com.dantas.springbootcrud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // define essa classe como um controlador MVC
public class AdminsController {
    @GetMapping("/admins")
    public String index(Model model){
        return "admins/index";
    }

}