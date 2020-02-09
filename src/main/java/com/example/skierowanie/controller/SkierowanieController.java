package com.example.skierowanie.controller;

import com.example.skierowanie.model.SkierowanieDoLekarza;
import com.example.skierowanie.serwis.SkierowanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/skierowanie")
public class SkierowanieController {

    @Autowired
    SkierowanieService service;


    public SkierowanieController(SkierowanieService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listSkierowanie(Model model) {
        model.addAttribute("skierowania", service.listSkierowanie());
        return "list-skierowanie";
    }

    @GetMapping("/{id}")
    public String getSkierowanie(@PathVariable Integer id, Model model) {
        SkierowanieDoLekarza skierowanieDoLekarza = service.getSkierowanie(id);
        model.addAttribute("skierowanie", skierowanieDoLekarza);
        return "get-skierowanie";
    }

    @GetMapping("/dodaj")
    public String dodajSkierowanie(Model model) {
        model.addAttribute("skierowanie", new SkierowanieDoLekarza());
        return "dodaj-skierowanie";
    }

    @PostMapping("/dodaj")
    public String stworzSkierowanie(
            @Valid
            @ModelAttribute SkierowanieDoLekarza skierowanieDoLekarza,
            Model model,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("skierowanie", skierowanieDoLekarza);
            return "dodaj-skierowanie";
        }
        service.createSkierowanie(skierowanieDoLekarza.getLekarz(), skierowanieDoLekarza.getPacjent(), skierowanieDoLekarza.getTermin());
        return "redirect:/skierowanie/list";
    }

    @GetMapping("/modyfikuj/{id}")
    public String modyfikujSkierowanie(@PathVariable Integer id, Model model) {
        model.addAttribute("skierowanie", service.getSkierowanie(id));
        return "modyfikuj-skierowanie";
    }

    @PostMapping("/modyfikuj")
    public String updateSkierowanie(@Valid @ModelAttribute SkierowanieDoLekarza skierowanieDoLekarza,
                                    Model model,
                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("skierowanie", skierowanieDoLekarza);
            return "modyfikuj-skierowanie";
        }
        service.updateSkierowanie(skierowanieDoLekarza);
        return String.format ("redirect:/skierowanie/%d", skierowanieDoLekarza.getId());
    }

    @GetMapping("/usun/{id}")
    public String usunSkierowanie(@PathVariable Integer id) {
        service.deleteSkierowanie(id);
        return "redirect:/skierowanie/list";
    }
}