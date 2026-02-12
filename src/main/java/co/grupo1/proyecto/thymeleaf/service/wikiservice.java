package co.grupo1.proyecto.thymeleaf.service;

import org.springframework.stereotype.Service;

import co.grupo1.proyecto.thymeleaf.model.wikipage;

import java.util.List;

@Service
public class wikiservice {

    private final List<wikipage> paginas = List.of(
        new wikipage("spring", "Spring Boot", "Framework Java para aplicaciones web."),
        new wikipage("thymeleaf", "Thymeleaf", "Motor de plantillas server-side."),
        new wikipage("docker", "Docker", "Contenedores para despliegue.")
    );
    
    public List<wikipage> findAll() {
        return paginas;
    }

    public wikipage findBySlug(String slug) {
        return paginas.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
    }
    
}
