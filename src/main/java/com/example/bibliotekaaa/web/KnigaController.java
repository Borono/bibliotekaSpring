package com.example.bibliotekaaa.web;

import com.example.bibliotekaaa.model.Kniga;
import com.example.bibliotekaaa.service.KnigaService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class KnigaController {
    private final KnigaService knigaService;

    public KnigaController(KnigaService knigaService) {
        this.knigaService = knigaService;
    }


    @GetMapping("/list")
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Kniga> booksList = this.knigaService.listAll();
        model.addAttribute("booksList", booksList);
        return "booksPage";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        this.knigaService.deleteById(id);
        return "redirect:/books/list";
    }

    @GetMapping("/addBook")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String showFormForAddBook(Model theModel) {

        // create model attribute to bind form data
        Kniga kniga = new Kniga();

        theModel.addAttribute("kniga", kniga);

        return "add-book";
    }
    @GetMapping("/edit-form/{id}")
    public String editProductPage(@PathVariable Long id, Model model) {

        Kniga kniga = this.knigaService.findById(id).get();
        this.knigaService.deleteById(id);
        model.addAttribute("kniga", kniga);
        return "add-book";


    }


    @PostMapping("/add")
    public String saveUser(

            @RequestParam String name,
            @RequestParam String price,
            @RequestParam String year,
            @RequestParam String horsepower,
            @RequestParam String image

    ){
        this.knigaService.save( name, price, year, horsepower, image);
        return "redirect:/books/list";
    }
}
