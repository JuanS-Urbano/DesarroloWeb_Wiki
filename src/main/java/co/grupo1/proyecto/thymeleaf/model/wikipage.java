package co.grupo1.proyecto.thymeleaf.model;

import java.time.LocalDate;
import java.util.List;

public class wikipage {

    private String slug;
    private String titulo;
    private String contenido;
    private String desarrollador;
    private String publisher;
    private LocalDate fechaLanzamiento;
    private List<String> plataformas;
    private List<String> generos;
    private String imagenPortada;
    private double calificacion;
    private String contenidoDetallado;
    private String trailer;
    private int numeroJugadores;
    private boolean multijugadorOnline;
    private String clasificacionEdad;

    public wikipage (String slug, String titulo, String contenido, String desarrollador, 
                    String publisher, LocalDate fechaLanzamiento, List<String> plataformas, 
                    List<String> generos, String imagenPortada, double calificacion, 
                    String contenidoDetallado, String trailer, int numeroJugadores, 
                    boolean multijugadorOnline, String clasificacionEdad) {
        this.slug = slug;
        this.titulo = titulo;
        this.contenido = contenido;
        this.desarrollador = desarrollador;
        this.publisher = publisher;
        this.fechaLanzamiento = fechaLanzamiento;
        this.plataformas = plataformas;
        this.generos = generos;
        this.imagenPortada = imagenPortada;
        this.calificacion = calificacion;
        this.contenidoDetallado = contenidoDetallado;
        this.trailer = trailer;
        this.numeroJugadores = numeroJugadores;
        this.multijugadorOnline = multijugadorOnline;
        this.clasificacionEdad = clasificacionEdad;
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

    public String getDesarrollador() {
        return desarrollador;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public List<String> getPlataformas() {
        return plataformas;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public String getImagenPortada() {
        return imagenPortada;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getContenidoDetallado() {
        return contenidoDetallado;
    }

    public String getTrailer() {
        return trailer;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public boolean isMultijugadorOnline() {
        return multijugadorOnline;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public String getGenerosFormateados() {
        return generos != null ? String.join(", ", generos) : "";
    }

    public String getPlataformasFormateadas() {
        return plataformas != null ? String.join(", ", plataformas) : "";
    }

    public String getAnioLanzamiento() {
        return fechaLanzamiento != null ? String.valueOf(fechaLanzamiento.getYear()) : "Desconocido";
    }

}