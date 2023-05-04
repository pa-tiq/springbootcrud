package com.dantas.springbootcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dantas.springbootcrud.models.Admin;
import com.dantas.springbootcrud.repository.AdminsRepo;

@Controller
public class LoginController {

    @Autowired
    private AdminsRepo adminsrepo;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login/index";
    }

    @PostMapping(value = "/login")
    public String loginAction(Model model, Admin user, String remember) {
        Admin admin = adminsrepo.login(user.getEmail(), user.getPassword());
        if (admin != null) {
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid user or password");
        return "login/index";
    }

}
