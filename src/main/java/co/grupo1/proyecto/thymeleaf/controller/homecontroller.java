package co.grupo1.proyecto.thymeleaf.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homecontroller {
    
    @GetMapping("/")
    public String inicio(){
        return "home";
    }
}