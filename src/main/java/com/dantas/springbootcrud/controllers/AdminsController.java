package com.dantas.springbootcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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
    public String newAdminScreen() {
        return "admins/new";
    }

    @PostMapping("/admins/create")
    public String create(Admin admin) {
        adminsrepo.save(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/{id}/delete")
    public String delete(@PathVariable int id) {
        adminsrepo.deleteById(id);
        return "redirect:/admins";
    }

    @GetMapping("/admins/{id}")
    public String edit(@PathVariable int id, Model model) {
        Optional<Admin> admin = adminsrepo.findById(id);
        model.addAttribute("admin", admin.get());
        return "admins/edit";
    }

}