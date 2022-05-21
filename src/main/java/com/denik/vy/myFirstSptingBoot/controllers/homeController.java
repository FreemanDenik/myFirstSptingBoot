package com.denik.vy.myFirstSptingBoot.controllers;

import com.denik.vy.myFirstSptingBoot.models.User;
import com.denik.vy.myFirstSptingBoot.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homeController {
    private final UserServiceImp userService;

    @Autowired
    public homeController(UserServiceImp userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(ModelMap model) {
        model.addAttribute("model", userService.users());
        return "index";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @PostMapping("/create")
    public String create(User user) {
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.user(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, User user) {
        userService.edit(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

}
