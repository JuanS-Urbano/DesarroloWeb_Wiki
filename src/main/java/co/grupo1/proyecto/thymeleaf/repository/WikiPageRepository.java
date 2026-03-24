package co.grupo1.proyecto.thymeleaf.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.grupo1.proyecto.thymeleaf.model.wikipage;

@Repository
public interface WikiPageRepository extends JpaRepository<wikipage, Long> {

    Optional<wikipage> findBySlug(String slug);

    @Query("SELECT DISTINCT w FROM wikipage w JOIN w.generos g WHERE g = :genero")
    List<wikipage> findByGenero(@Param("genero") String genero);

    @Query("SELECT DISTINCT w FROM wikipage w JOIN w.plataformas p WHERE p = :plataforma")
    List<wikipage> findByPlataforma(@Param("plataforma") String plataforma);

    @Query("SELECT w FROM wikipage w WHERE LOWER(w.titulo) LIKE LOWER(CONCAT('%', :query, '%')) OR LOWER(w.contenido) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<wikipage> buscarPorNombre(@Param("query") String query);

    List<wikipage> findByCalificacionGreaterThanEqualOrderByCalificacionDesc(double calificacion);

    @Query("SELECT DISTINCT g FROM wikipage w JOIN w.generos g ORDER BY g")
    List<String> findAllGeneros();

    @Query("SELECT DISTINCT p FROM wikipage w JOIN w.plataformas p ORDER BY p")
    List<String> findAllPlataformas();
}
