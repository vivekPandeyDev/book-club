# Stage 1: Build the application
# Use Java 21 base image
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy the entire multi-module Maven project
COPY ../ ./

# Build only config-service and its dependencies
RUN mvn clean install -pl gateway-service -am -DskipTests

# Stage 2: Create a lightweight runtime image
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy the built jar from target (update if your jar has a different name)
COPY --from=builder /app/gateway-service/target/*.jar app.jar

# Expose the default Spring Boot port (can be overridden via env)
EXPOSE 8080

# Pass all environment variables as CLI args
ENTRYPOINT ["sh", "-c", "\
  java -jar app.jar \
  $(env | sed -e 's/^/--/' -e 's/=/=/g' | tr '\n' ' ')"]
