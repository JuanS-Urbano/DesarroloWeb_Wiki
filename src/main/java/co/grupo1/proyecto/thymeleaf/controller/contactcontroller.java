package co.grupo1.proyecto.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grupo1.proyecto.thymeleaf.model.ContactFormulario;
import co.grupo1.proyecto.thymeleaf.service.ContactService;

@Controller
@RequestMapping("/contacto")
public class contactcontroller {

    @Autowired
    private ContactService contactService;

    @GetMapping("/formulario")
    public String mostrarFormulario() {
        return "contact/contacto";
    }

    @PostMapping("/enviar")
    public String procesarFormulario(Model model,
            @RequestParam String nombrecompleto,
            @RequestParam String correo,
            @RequestParam String telefono,
            @RequestParam String asunto,
            @RequestParam String mensaje) {

        ContactFormulario form = new ContactFormulario(nombrecompleto, correo, telefono, asunto, mensaje);
        ContactFormulario guardado = contactService.guardarContacto(form);
        model.addAttribute("formulario", guardado);
        return "contact/contacto-exito";
    }
}