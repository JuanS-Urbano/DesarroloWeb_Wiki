# Multi-stage build
# Stage 1: Compilar con Maven
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
COPY mvnw.cmd .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests -B

# Stage 2: Ejecutar con JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Volumen para persistencia de H2
VOLUME ["/app/data"]
# Variable de entorno para H2 en Docker
ENV SPRING_DATASOURCE_URL=jdbc:h2:file:/app/data/demo;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;MODE=PostgreSQL
ENTRYPOINT ["java", "-jar", "app.jar"]
