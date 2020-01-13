package com.pomelers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.pomelers.domain.model.SignUpForm;
import com.pomelers.service.UserService;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String init() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute final SignUpForm form) {
        this.userService.register(form);
        return "redirect:/login";
    }

}
