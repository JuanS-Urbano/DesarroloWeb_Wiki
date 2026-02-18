package co.grupo1.proyecto.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.grupo1.proyecto.thymeleaf.model.wikipage;
import co.grupo1.proyecto.thymeleaf.repository.WikiPageRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class wikiservice {

    @Autowired
    private WikiPageRepository wikiPageRepository;

    public List<wikipage> findAll() {
        return wikiPageRepository.findAll();
    }

    public wikipage findBySlug(String slug) {
        return wikiPageRepository.findBySlug(slug).orElse(null);
    }

    public List<wikipage> findByGenero(String genero) {
        return wikiPageRepository.findByGenero(genero);
    }

    public List<wikipage> findByPlataforma(String plataforma) {
        return wikiPageRepository.findByPlataforma(plataforma);
    }

    public List<wikipage> buscarPorNombre(String query) {
        return wikiPageRepository.buscarPorNombre(query);
    }

    public List<wikipage> findRecientes() {
        LocalDate limite = LocalDate.now().minusYears(5);
        List<wikipage> todas = wikiPageRepository.findAll();
        return todas.stream()
                .filter(p -> p.getFechaLanzamiento() != null && p.getFechaLanzamiento().isAfter(limite))
                .toList();
    }

    public List<wikipage> findMejorCalificados() {
        return wikiPageRepository.findByCalificacionGreaterThanEqualOrderByCalificacionDesc(9.0);
    }

    public List<String> getAllGeneros() {
        return wikiPageRepository.findAllGeneros();
    }

    public List<String> getAllPlataformas() {
        return wikiPageRepository.findAllPlataformas();
    }

    public long contarPaginas() {
        return wikiPageRepository.count();
    }
}