package com.example.inspection.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // src/main/resources/templates/home.html dosyasına yönlendirir
    }
}
