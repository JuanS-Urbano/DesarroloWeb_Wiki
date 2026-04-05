package co.grupo1.proyecto.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.grupo1.proyecto.thymeleaf.model.ContactFormulario;

@Repository
public interface ContactFormularioRepository extends JpaRepository<ContactFormulario, Long> {
}
