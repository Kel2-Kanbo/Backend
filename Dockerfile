# Import base JDK from Linux
FROM adoptopenjdk/openjdk11:alpine

# Set work directory
WORKDIR /app

# Copy application files
COPY target/*.jar app.jar

# Expose PORT
EXPOSE 8080:80
EXPOSE 443:443

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]