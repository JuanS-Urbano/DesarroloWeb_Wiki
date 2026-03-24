package co.grupo1.proyecto.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.grupo1.proyecto.thymeleaf.model.ContactFormulario;
import co.grupo1.proyecto.thymeleaf.repository.ContactFormularioRepository;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactFormularioRepository contactFormularioRepository;

    public ContactFormulario guardarContacto(ContactFormulario formulario) {
        return contactFormularioRepository.save(formulario);
    }

    public List<ContactFormulario> obtenerTodosLosContactos() {
        return contactFormularioRepository.findAll();
    }
}
