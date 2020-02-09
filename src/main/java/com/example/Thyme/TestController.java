package com.example.Thyme;


import com.example.Thyme.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.example.Thyme.service.UserService;

import javax.naming.Binding;

@Controller
public class TestController {

    public static class NotFoundException extends RuntimeException {
    }

    @Autowired
    UserService userService;

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "list-users-view";
    }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable String id, Model model) {
        int i = Integer.parseInt(id);
        User user = userService.getUser(i);
        if(user == null){
            throw new NotFoundException();
        }
        model.addAttribute("user", user);
        return "user-details";

    }


    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/addUser")
    public String createUser(@ModelAttribute User user, BindingResult bindingResult, Model model) {
        validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/addUser";
        }

        userService.createUser(user.getImie(), user.getNazwisko(), user.getWiek());
        return "redirect:/listUsers";
    }

    @ExceptionHandler(NotFoundException.class)
    public String notFound() {
        return "404";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String notFoundA() {
        return "Exceptions";
    }


    public void validate(User user, BindingResult bindingResult) {
        if (user.getImie() == null || user.getImie().isEmpty()) {
            bindingResult.addError(new ObjectError("imie", "Musisz podać imię!"));
        }
        if (user.getNazwisko() == null || user.getNazwisko().isEmpty()) {
            bindingResult.addError(new ObjectError("nazwisko", "Musisz podać nazwisko!"));
        }
        if (user.getWiek() < 0) {
            bindingResult.addError(new ObjectError("wiek", "Wiek nie może być ujemny!"));


            // User user = new User (13, "Wiol", "Zur", 34);
        /*List<User> users = new ArrayList<>();
        users.add(new User(12, "Anna", "Kowalska", 11));
        users.add(new User(12, "Kasia", "Kowalczyk", 22));
        users.add(new User(12, "Karol", "Kowal", 33));
        users.add(new User(12, "Krzysztof", "Krawczyk", 44));*/


        }

    }
}