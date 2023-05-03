package com.dantas.springbootcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.dantas.springbootcrud.repository.AdminsRepo;
import com.dantas.springbootcrud.models.Admin;

@Controller // define essa classe como um controlador MVC
public class AdminsController {

    @Autowired
    private AdminsRepo adminsrepo;

    @GetMapping("/admins")
    public String index(Model model) {
        List<Admin> admins = (List<Admin>) adminsrepo.findAll();
        model.addAttribute("admins", admins);
        return "admins/index";
    }

    @GetMapping("/admins/new")
    public String newAdmin() {
        return "admins/new";
    }

}