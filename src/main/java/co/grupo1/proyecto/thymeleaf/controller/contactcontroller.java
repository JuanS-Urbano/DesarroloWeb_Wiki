package co.grupo1.proyecto.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grupo1.proyecto.thymeleaf.model.ContactFormulario;

@Controller
@RequestMapping("/contacto")
public class contactcontroller {

    @GetMapping("/formulario")
    public String mostrarformualrio() {
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
        model.addAttribute("formulario", form);
        return "contact/contacto-exito";
    }
}