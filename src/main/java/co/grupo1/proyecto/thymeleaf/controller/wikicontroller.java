package co.grupo1.proyecto.thymeleaf.controller;

import co.grupo1.proyecto.thymeleaf.model.wikipage;
import co.grupo1.proyecto.thymeleaf.service.wikiservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/wiki")

public class wikicontroller {
    
    @Autowired
    private wikiservice wikiservice;
    
    @GetMapping("/lista")
    public String listapaginas(Model model) {
        List<wikipage> paginas = wikiservice.findAll();
        model.addAttribute("pagina", paginas);
        return "wiki/lista-wiki";
    }

    @GetMapping("/pagina")
    public String verpagina(@RequestParam String slug, Model model) {
        wikipage pagina = wikiservice.findBySlug(slug);
        model.addAttribute("pagina", pagina);
        return "wiki/pagina-wiki";
    }
}
