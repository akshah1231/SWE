package com.example.eregistrar.controller;

import ch.qos.logback.core.model.Model;
import com.example.eregistrar.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/eregistrar")
public class HomeController {
    @GetMapping("/home")
    public String home() {
        // Return the homepage view
        return "home";
    }
    // Other controller methods for menu items

}

