# Use an official JDK runtime as a parent image
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the built JAR file from the target directory
COPY target/comp367-webapp-1.0-SNAPSHOT.jar app.jar

# Expose port 8080 for external access
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
