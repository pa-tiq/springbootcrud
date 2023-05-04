package com.dantas.springbootcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.dantas.springbootcrud.models.Admin;
import com.dantas.springbootcrud.repository.AdminsRepo;
import com.dantas.springbootcrud.services.CookieService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AdminsRepo adminsrepo;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login/index";
    }

    @PostMapping(value = "/login")
    public String loginAction(Model model, Admin user, HttpServletResponse response) {
        Admin admin = adminsrepo.login(user.getEmail(), user.getPassword());
        if (admin != null) {
            CookieService.setCookie(response, "userId", String.valueOf(admin.getId()), 60);
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid user or password");
        return "login/index";
    }

}
