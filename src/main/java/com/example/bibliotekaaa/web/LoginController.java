package com.example.bibliotekaaa.web;

import com.example.bibliotekaaa.model.Korisnik;
import com.example.bibliotekaaa.model.exceptions.InvalidArgumentException;
import com.example.bibliotekaaa.service.KorisnikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final KorisnikService korisnikService;

    public LoginController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }
    @GetMapping
    public String getLoginPage(){
        return "login";
    }
    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        Korisnik korisnik = null;
        try{
            korisnik = this.korisnikService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("korisnik", korisnik);
            return "redirect:/home";
        }
        catch (InvalidArgumentException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }

}
