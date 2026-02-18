package co.grupo1.proyecto.thymeleaf.service;

import org.springframework.stereotype.Service;

import co.grupo1.proyecto.thymeleaf.model.wikipage;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class wikiservice {

    private final List<wikipage> paginas = List.of(
        new wikipage(
            "the-legend-of-zelda-breath-of-the-wild",
            "The Legend of Zelda: Breath of the Wild",
            "Una aventura épica de mundo abierto donde Link despierta después de 100 años para derrotar a Calamity Ganon y salvar Hyrule.",
            "Nintendo EPD",
            "Nintendo",
            LocalDate.of(2017, 3, 3),
            List.of("Nintendo Switch", "Wii U"),
            List.of("Aventura", "Acción", "Mundo Abierto"),
            "/images/zelda-botw.jpg",
            9.7,
            "Explora un vasto mundo abierto lleno de secretos, templos y desafíos. Con física realista y libertad absoluta de exploración, podrás escalar cualquier montaña, planear por los cielos y descubrir más de 100 santuarios. El juego revolucionó la franquicia con su enfoque no-lineal y sistemas emergentes.",
            "https://www.youtube.com/watch?v=zw47_q9wbBE",
            1,
            false,
            "E10+"
        ),
        new wikipage(
            "elden-ring",
            "Elden Ring",
            "Un RPG de acción oscuro y desafiante creado por FromSoftware en colaboración con George R.R. Martin.",
            "FromSoftware",
            "Bandai Namco",
            LocalDate.of(2022, 2, 25),
            List.of("PS5", "PS4", "Xbox Series X/S", "Xbox One", "PC"),
            List.of("RPG", "Acción", "Souls-like", "Mundo Abierto"),
            "/images/elden-ring.jpg",
            9.5,
            "Explora las Tierras Intermedias en este RPG de mundo abierto. Enfrenta jefes épicos, personaliza tu personaje con decenas de clases y habilidades, y descubre la historia fragmentada del Círculo de Elden. Con un mundo interconectado lleno de mazmorras, castillos y secretos por descubrir.",
            "https://www.youtube.com/watch?v=E3Huy2cdih0",
            1,
            true,
            "M"
        ),
        new wikipage(
            "god-of-war-ragnarok",
            "God of War: Ragnarök",
            "Kratos y Atreus se enfrentan al destino mientras se acerca el fin del mundo nórdico.",
            "Santa Monica Studio",
            "Sony Interactive Entertainment",
            LocalDate.of(2022, 11, 9),
            List.of("PS5", "PS4"),
            List.of("Acción", "Aventura", "Hack and Slash"),
            "/images/gow-ragnarok.jpg",
            9.4,
            "Una épica conclusión de la saga nórdica con combate brutal, historia emotiva y gráficos impresionantes. Viaja por los nueve reinos, enfrenta a dioses y criaturas míticas, y descubre el destino de Kratos y Atreus en esta aventura cinematográfica con mecánicas de combate mejoradas y puzzles ingeniosos.",
            "https://www.youtube.com/watch?v=EE-4GvjKcfs",
            1,
            false,
            "M"
        ),
        new wikipage(
            "minecraft",
            "Minecraft",
            "El juego sandbox definitivo donde puedes construir, explorar y sobrevivir en un mundo de bloques infinito.",
            "Mojang Studios",
            "Microsoft",
            LocalDate.of(2011, 11, 18),
            List.of("PC", "PS5", "PS4", "Xbox Series X/S", "Xbox One", "Nintendo Switch", "Mobile"),
            List.of("Sandbox", "Supervivencia", "Creatividad"),
            "/images/minecraft.jpg",
            9.0,
            "Construye lo que imagines en un mundo generado proceduralmente. Recolecta recursos, craftea herramientas, construye refugios y explora cuevas, biomas y dimensiones. Con modos Supervivencia, Creativo y Hardcore, además de soporte para mods y servidores multijugador masivos.",
            "https://www.youtube.com/watch?v=MmB9b5njVbA",
            8,
            true,
            "E10+"
        ),
        new wikipage(
            "the-witcher-3",
            "The Witcher 3: Wild Hunt",
            "Geralt de Rivia busca a su hija adoptiva mientras navega por un mundo lleno de monstruos y decisiones morales.",
            "CD Projekt Red",
            "CD Projekt",
            LocalDate.of(2015, 5, 19),
            List.of("PC", "PS5", "PS4", "Xbox Series X/S", "Xbox One", "Nintendo Switch"),
            List.of("RPG", "Aventura", "Mundo Abierto"),
            "/images/witcher3.jpg",
            9.8,
            "Un RPG masivo con narrativa profunda, combate táctico y un mundo vivo lleno de consecuencias. Cada decisión importa en este juego con múltiples finales. Explora un mundo de fantasía oscura, completa contratos de caza de monstruos, juega al Gwent y vive una historia épica con personajes memorables.",
            "https://www.youtube.com/watch?v=c0i88t0Kacs",
            1,
            false,
            "M"
        ),
        new wikipage(
            "hades",
            "Hades",
            "Un roguelike de acción donde Zagreus intenta escapar del Inframundo griego una y otra vez.",
            "Supergiant Games",
            "Supergiant Games",
            LocalDate.of(2020, 9, 17),
            List.of("PC", "PS5", "PS4", "Xbox Series X/S", "Xbox One", "Nintendo Switch"),
            List.of("Roguelike", "Acción", "Indie"),
            "/images/hades.jpg",
            9.3,
            "Combate fluido, narrativa dinámica que evoluciona con cada muerte, y arte espectacular inspirado en la mitología griega. Cada intento de escape es único gracias a las bendiciones de los dioses del Olimpo. Desbloquea armas, mejoras permanentes y descubre los secretos de tu familia divina.",
            "https://www.youtube.com/watch?v=91t0ha9x0AE",
            1,
            false,
            "T"
        )
    );
    
    public List<wikipage> findAll() {
        return paginas;
    }

    public wikipage findBySlug(String slug) {
        return paginas.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
    }
    
    public List<wikipage> findByGenero(String genero) {
        return paginas.stream()
            .filter(p -> p.getGeneros() != null && p.getGeneros().contains(genero))
            .collect(Collectors.toList());
    }
    
    public List<wikipage> findByPlataforma(String plataforma) {
        return paginas.stream()
            .filter(p -> p.getPlataformas() != null && p.getPlataformas().contains(plataforma))
            .collect(Collectors.toList());
    }
    
    public List<wikipage> buscarPorNombre(String query) {
        String queryLower = query.toLowerCase();
        return paginas.stream()
            .filter(p -> p.getTitulo().toLowerCase().contains(queryLower) ||
                        p.getContenido().toLowerCase().contains(queryLower))
            .collect(Collectors.toList());
    }
    
    public List<wikipage> findRecientes() {
        LocalDate dosAniosAtras = LocalDate.now().minusYears(2);
        return paginas.stream()
            .filter(p -> p.getFechaLanzamiento() != null && 
                        p.getFechaLanzamiento().isAfter(dosAniosAtras))
            .collect(Collectors.toList());
    }
    
    public List<wikipage> findMejorCalificados() {
        return paginas.stream()
            .filter(p -> p.getCalificacion() >= 9.0)
            .sorted((p1, p2) -> Double.compare(p2.getCalificacion(), p1.getCalificacion()))
            .collect(Collectors.toList());
    }
    
    public List<String> getAllGeneros() {
        return paginas.stream()
            .flatMap(p -> p.getGeneros() != null ? p.getGeneros().stream() : List.<String>of().stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }
    
    public List<String> getAllPlataformas() {
        return paginas.stream()
            .flatMap(p -> p.getPlataformas() != null ? p.getPlataformas().stream() : List.<String>of().stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }
    
}