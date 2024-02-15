# Stage 1: Build the application
FROM maven:4.0.0-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/quiz_app-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080

CMD ["java", "-jar", "quiz_app-0.0.1-SNAPSHOT.jar"]