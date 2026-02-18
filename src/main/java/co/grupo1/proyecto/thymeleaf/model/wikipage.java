package co.grupo1.proyecto.thymeleaf.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "wiki_page")
public class wikipage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String slug;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 1000)
    private String contenido;

    private String desarrollador;
    private String publisher;
    private LocalDate fechaLanzamiento;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "wiki_page_plataformas", joinColumns = @JoinColumn(name = "wiki_page_id"))
    @Column(name = "plataforma")
    private List<String> plataformas;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "wiki_page_generos", joinColumns = @JoinColumn(name = "wiki_page_id"))
    @Column(name = "genero")
    private List<String> generos;

    private String imagenPortada;
    private double calificacion;

    @Column(length = 2000)
    private String contenidoDetallado;

    private String trailer;
    private int numeroJugadores;
    private boolean multijugadorOnline;
    private String clasificacionEdad;

    // Constructor vacío requerido por JPA
    public wikipage() {
    }

    public wikipage(String slug, String titulo, String contenido, String desarrollador,
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

    // Getters
    public Long getId() {
        return id;
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

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setPlataformas(List<String> plataformas) {
        this.plataformas = plataformas;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public void setImagenPortada(String imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setContenidoDetallado(String contenidoDetallado) {
        this.contenidoDetallado = contenidoDetallado;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public void setNumeroJugadores(int numeroJugadores) {
        this.numeroJugadores = numeroJugadores;
    }

    public void setMultijugadorOnline(boolean multijugadorOnline) {
        this.multijugadorOnline = multijugadorOnline;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    // Métodos de utilidad
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