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
    public String createScreen() {
        return "admins/new";
    }

    @PostMapping("/admins/create")
    public String createAction(Admin admin) {
        adminsrepo.save(admin);
        return "redirect:/admins";
    }

    @GetMapping("/admins/{id}/delete")
    public String deleteAction(@PathVariable int id) {
        adminsrepo.deleteById(id);
        return "redirect:/admins";
    }

    @GetMapping("/admins/{id}")
    public String editScreen(@PathVariable int id, Model model) {
        Optional<Admin> admin = adminsrepo.findById(id);
        try {
            model.addAttribute("admin", admin.get());

        } catch (Exception e) {
            return "redirect:/admins";
        }
        return "admins/edit";
    }

    @PostMapping("/admins/{id}/edit")
    public String editAction(@PathVariable int id, Admin admin) {
        // já existe o método existById, mas criei esse só pra aprender como faz
        if (adminsrepo.exist(id)) {
            adminsrepo.save(admin);
            return "redirect:/admins";
        }
        return "admins/edit";
    }
}