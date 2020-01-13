package com.pomelers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.pomelers.domain.model.SignUpForm;
import com.pomelers.domain.model.validator.ValidationGroups;
import com.pomelers.service.UserService;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String init(@ModelAttribute("form") final SignUpForm form) {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(
            @ModelAttribute("form") @Validated(ValidationGroups.class) final SignUpForm form,
            final BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }
        this.userService.register(form);
        return "redirect:/login";
    }

}
