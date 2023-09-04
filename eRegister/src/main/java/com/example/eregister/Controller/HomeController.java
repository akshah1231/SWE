package com.example.eregister.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value={"/","eregister","eregister/home"})
    public String displayHome(){
        return "home/index.html";
    }
}
