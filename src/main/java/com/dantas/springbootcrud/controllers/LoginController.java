package com.dantas.springbootcrud.controllers;

import java.io.UnsupportedEncodingException;

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
    public String loginAction(Model model, Admin user, String remember, HttpServletResponse response)
            throws UnsupportedEncodingException {
        Admin admin = adminsrepo.login(user.getEmail(), user.getPassword());
        if (admin != null) {
            int timeLoggedIn = 60;
            if (remember != null) {
                timeLoggedIn = 60 * 60 * 24 * 365;
            }
            CookieService.setCookie(response, "userId", String.valueOf(admin.getId()), timeLoggedIn);
            CookieService.setCookie(response, "name", admin.getName(), timeLoggedIn);
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid user or password");
        return "login/index";
    }

    @GetMapping(value = "/logout")
    public String logoutAction(HttpServletResponse response) throws UnsupportedEncodingException {
        CookieService.setCookie(response, "userId", "", 0);
        CookieService.setCookie(response, "name", "", 0);
        return "redirect:/login";
    }

}
