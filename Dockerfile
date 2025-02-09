# Stage 1: Build
FROM openjdk:17-jdk AS build
WORKDIR /app

# Copy Maven wrapper and settings first (caching optimization)
COPY mvnw ./
COPY .mvn .mvn

# Copy POM.xml before src (to leverage Docker cache)
COPY pom.xml ./

# Download dependencies before copying full source code
RUN chmod +x ./mvnw && ./mvnw dependency:go-offline

# Now copy source code
COPY src ./src

# Build the project, skipping tests for now
RUN ./mvnw clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose port (Render assigns dynamically)
EXPOSE 8089

# Run the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
