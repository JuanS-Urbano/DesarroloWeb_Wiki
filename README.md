# Wiki de Videojuegos - Taller de Desarrollo Web

Este proyecto es una aplicación web tipo Wiki desarrollada con **Spring Boot** y **Thymeleaf**, diseñada para gestionar y visualizar información sobre videojuegos. El sistema sigue una arquitectura **MVC (Modelo-Vista-Controlador)** estricta y utiliza **H2** como base de datos en memoria.

## 🚀 Despliegue y Ejecución (Docker)

La forma principal y recomendada de ejecutar la aplicación es mediante **Docker**, cumpliendo con los requisitos de despliegue.

### Prerrequisitos
- Tener instalado **Docker Desktop** (o Docker Engine en Linux).

### Pasos para ejecutar

1.  **Abrir una terminal** en la raíz del proyecto (donde está el archivo `Dockerfile`).
2.  **Construir la imagen Docker**:
    ```bash
    docker build -t wiki-app .
    ```
3.  **Ejecutar el contenedor**:
    ```bash
    docker run -p 8080:8080 wiki-app
    ```

    O para persistencia de datos:

    ```bash
    docker run -p 8080:8080 -v wiki-data:/app/data wiki-app:latest
    ```
4.  **Acceder a la aplicación**:
    Abre tu navegador web e ingresa a: [http://localhost:8080](http://localhost:8080)

---

## 🛠️ Ejecución Local (Alternativa con Maven)

Si no deseas usar Docker, puedes ejecutar la aplicación directamente usando el wrapper de Maven incluido.

**En Windows (PowerShell/CMD):**
```bash
.\mvnw.cmd spring-boot:run
```

**En Linux/Mac:**
```bash
./mvnw spring-boot:run
```

---

## 🏗️ Arquitectura y Tecnologías

El proyecto sigue una arquitectura en capas para garantizar la separación de responsabilidades:

-   **Backend**: Spring Boot 3 (Java 17/21).
-   **Frontend**: Thymeleaf (Motor de plantillas server-side), HTML5, CSS3, JavaScript.
-   **Base de Datos**: H2 Database (En memoria, persistida en ejecución).
-   **Validación**: Lógica de validación robusta en **JavaScript** (lado cliente) y soporte en backend.

### Estructura del Código

-   **`controller/`**: Maneja las solicitudes HTTP (`homecontroller`, `wikicontroller`, `contactcontroller`).
-   **`service/`**: Contiene la lógica de negocio (`wikiservice`, `ContactService`).
-   **`repository/`**: Capa de acceso a datos usando Spring Data JPA (`WikiPageRepository`).
-   **`model/`**: Entidades JPA (`wikipage`, `ContactFormulario`).
-   **`templates/`**: Vistas HTML con Thymeleaf. Usa fragmentos reutilizables en `layout.html`.
-   **`static/`**: Archivos CSS y JavaScript para el frontend.

## ✅ Características Implementadas

1.  **Wiki Dinámica**: Listado de juegos, filtrado por género/plataforma, y búsqueda.
2.  **Detalle de Juego**: Renderizado completo de información con imágenes, embeds de video y badges.
3.  **Formulario de Contacto**:
    -   Validación en tiempo real con JavaScript.
    -   Contador de caracteres para el mensaje (min 20, max 400).
    -   Feedback visual (errores inline, banner de éxito).
    -   Persistencia de mensajes en base de datos H2.
4.  **Carga de Datos**: `DataInitializer` puebla la base de datos automáticamente al iniciar.
