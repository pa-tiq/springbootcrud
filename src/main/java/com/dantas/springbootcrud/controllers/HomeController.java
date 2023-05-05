package com.dantas.springbootcrud.controllers;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dantas.springbootcrud.services.CookieService;

import jakarta.servlet.http.HttpServletRequest;

@Controller // define essa classe como um controlador MVC
public class HomeController {
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        model.addAttribute("nome", CookieService.getCookie(request, "name"));
        return "home/index";
    }

}
