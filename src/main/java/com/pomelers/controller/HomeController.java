package com.pomelers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/{userid}")
    public String home(@PathVariable final String userid) {
        return "home";
    }

}
