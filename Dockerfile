# Utilisation de l'image officielle JDK avec apt-get disponible
FROM openjdk:21-jdk AS build
# Définir le répertoire de travail
WORKDIR /app

# Copier le fichier POM et les fichiers sources
COPY pom.xml .
COPY src ./src

# Build du projet avec Maven
RUN mvn clean package -DskipTests

# Utiliser l'image JRE pour l'exécution
FROM openjdk:21

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR généré par Maven dans l'image
COPY --from=build /app/target/movie-management-0.0.1-SNAPSHOT.jar movie-management.jar

# Exposer le port que l'application utilise
EXPOSE 8082

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "movie-management.jar"]
