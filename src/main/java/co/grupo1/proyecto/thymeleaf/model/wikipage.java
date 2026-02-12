package co.grupo1.proyecto.thymeleaf.model;

public class wikipage {

    private String slug;
    private String titulo;
    private String contenido;

    public wikipage (String slug, String titulo, String contenido) {
        this.slug = slug;
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
      public String getSlug() {
        return slug;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

}
