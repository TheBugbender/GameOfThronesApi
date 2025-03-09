# Stage 1: Build the application
FROM gradle:latest AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

# Stage 2: Create a lightweight runtime image
FROM amazoncorretto:22 AS runtime
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]