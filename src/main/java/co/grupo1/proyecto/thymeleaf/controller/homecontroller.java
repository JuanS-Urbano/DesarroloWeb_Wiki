package co.grupo1.proyecto.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.grupo1.proyecto.thymeleaf.model.wikipage;
import co.grupo1.proyecto.thymeleaf.service.wikiservice;

@Controller
public class homecontroller {

    @Autowired
    private wikiservice wikiService;

    @GetMapping("/")
    public String inicio(Model model) {
        long totalPaginas = wikiService.contarPaginas();
        List<wikipage> recientes = wikiService.findRecientes();
        List<String> generos = wikiService.getAllGeneros();

        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("recientes", recientes);
        model.addAttribute("generos", generos);
        return "home";
    }
}