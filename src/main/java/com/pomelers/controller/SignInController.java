package com.pomelers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.pomelers.domain.model.SignInForm;

@Controller
public class SignInController {

    @GetMapping("/login")
    public String init(@ModelAttribute("form") final SignInForm form) {
        return "login";
    }

}
