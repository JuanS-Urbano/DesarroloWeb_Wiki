package co.grupo1.proyecto.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grupo1.proyecto.thymeleaf.model.wikipage;
import co.grupo1.proyecto.thymeleaf.service.wikiservice;


@Controller
@RequestMapping("/wiki")

public class wikicontroller {
    
    @Autowired
    private wikiservice wikiservice;
    
    @GetMapping("/lista")
    public String listapaginas(Model model) {
        List<wikipage> paginas = wikiservice.findAll();
        model.addAttribute("pagina", paginas);
        model.addAttribute("generos", wikiservice.getAllGeneros());
        model.addAttribute("plataformas", wikiservice.getAllPlataformas());
        return "wiki/lista-wiki";
    }

    @GetMapping("/pagina")
    public String verpagina(@RequestParam String slug, Model model) {
        wikipage pagina = wikiservice.findBySlug(slug);
        model.addAttribute("pagina", pagina);
        return "wiki/pagina-wiki";
    }
    
    @GetMapping("/genero")
    public String filtrarPorGenero(@RequestParam String genero, Model model) {
        List<wikipage> paginas = wikiservice.findByGenero(genero);
        model.addAttribute("pagina", paginas);
        model.addAttribute("generoSeleccionado", genero);
        model.addAttribute("generos", wikiservice.getAllGeneros());
        model.addAttribute("plataformas", wikiservice.getAllPlataformas());
        return "wiki/lista-wiki";
    }
    
    @GetMapping("/plataforma")
    public String filtrarPorPlataforma(@RequestParam String plataforma, Model model) {
        List<wikipage> paginas = wikiservice.findByPlataforma(plataforma);
        model.addAttribute("pagina", paginas);
        model.addAttribute("plataformaSeleccionada", plataforma);
        model.addAttribute("generos", wikiservice.getAllGeneros());
        model.addAttribute("plataformas", wikiservice.getAllPlataformas());
        return "wiki/lista-wiki";
    }
    
    @GetMapping("/buscar")
    public String buscarVideoJuegos(@RequestParam String query, Model model) {
        List<wikipage> paginas = wikiservice.buscarPorNombre(query);
        model.addAttribute("pagina", paginas);
        model.addAttribute("busqueda", query);
        model.addAttribute("generos", wikiservice.getAllGeneros());
        model.addAttribute("plataformas", wikiservice.getAllPlataformas());
        return "wiki/lista-wiki";
    }
    
    @GetMapping("/recientes")
    public String videojuegosRecientes(Model model) {
        List<wikipage> paginas = wikiservice.findRecientes();
        model.addAttribute("pagina", paginas);
        model.addAttribute("filtro", "Videojuegos Recientes");
        return "wiki/lista-wiki";
    }
    
    @GetMapping("/mejores")
    public String mejoresVideojuegos(Model model) {
        List<wikipage> paginas = wikiservice.findMejorCalificados();
        model.addAttribute("pagina", paginas);
        model.addAttribute("filtro", "Mejor Calificados");
        return "wiki/lista-wiki";
    }
}