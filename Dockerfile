# Use the official OpenJDK 11 image as the base image
FROM openjdk:17-oracle

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/ms-categorie-0.0.1-SNAPSHOT.jar /app/ms-categorie-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application is listening on (if needed)
EXPOSE 8087

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "ms-categorie-0.0.1-SNAPSHOT.jar"]