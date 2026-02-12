package co.grupo1.proyecto.thymeleaf.model;

public class ContactFormulario {

    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String asunto;
    private String mensaje;

    public ContactFormulario(String nombreCompleto, String correo, String telefono, String asunto, String mensaje) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
    
    public String getNombreCompleto() { 
        return nombreCompleto; 
    }

    public String getCorreo() { 
        return correo; 
    }

    public String getTelefono() { 
        return telefono; 
    }

    public String getAsunto() { 
        return asunto; 
    }

    public String getMensaje() { 
        return mensaje; 
    }
}
