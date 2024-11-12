FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Étape 2 : Ajouter un argument pour le fichier JAR
ARG JAR_FILE=*.jar

# Étape 3 : Copier le fichier JAR dans l'image Docker
COPY target/${JAR_FILE} app.jar

# Étape 4 : Exposer le port sur lequel l'application Spring Boot fonctionne
EXPOSE 8086

# Étape 5 : Démarrer l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]
