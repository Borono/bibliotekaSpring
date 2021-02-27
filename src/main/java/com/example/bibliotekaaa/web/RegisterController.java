package com.example.bibliotekaaa.web;

import com.example.bibliotekaaa.model.exceptions.InvalidArgumentException;
import com.example.bibliotekaaa.service.KorisnikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final KorisnikService korisnikService;

    public RegisterController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname) {
        try{
            this.korisnikService.register(username, password, repeatedPassword, name, surname);
            return "redirect:/login";
        } catch (InvalidArgumentException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
