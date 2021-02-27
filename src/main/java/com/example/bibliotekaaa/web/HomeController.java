package com.example.bibliotekaaa.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("home")
    public String pocetna(){
        return "home";
    }
    @GetMapping("access_denied")
    public String accessDeniedPage(){
        return "access_denied";
    }
}