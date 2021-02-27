package com.example.bibliotekaaa.web;

import com.example.bibliotekaaa.model.Biblioteka;
import com.example.bibliotekaaa.service.BibliotekaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/biblioteka")
public class BibliotekaController {
    private final BibliotekaService bibliotekaService;

    public BibliotekaController(BibliotekaService bibliotekaService) {
        this.bibliotekaService = bibliotekaService;
    }
    @GetMapping("/list")
    public String getBibliotekaPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Biblioteka> libraryList = this.bibliotekaService.listAll();
        model.addAttribute("libraryList", libraryList);
        return "libraryPage";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBiblioteka(@PathVariable Long id) {
        this.bibliotekaService.deleteById(id);
        return "redirect:/biblioteka/list";
    }

    @GetMapping("/addbiblioteka")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Biblioteka biblioteka = new Biblioteka();

        theModel.addAttribute("biblioteka", biblioteka);

        return "add-biblioteka";
    }
    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {

        Biblioteka biblioteka = this.bibliotekaService.findById(id).get();
        this.bibliotekaService.deleteById(id);
        model.addAttribute("biblioteka", biblioteka);
        return "add-biblioteka";


    }


    @PostMapping("/add")
    public String saveBiblioteka(

            @RequestParam String name,
            @RequestParam String grad,
            @RequestParam String lokacija,
            @RequestParam String kapacitet

    ){
        this.bibliotekaService.save( name, grad, lokacija, kapacitet);
        return "redirect:/biblioteka/list";
    }
}