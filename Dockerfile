FROM maven:3.9.5-sapmachine-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/libs ./libs
COPY --from=build /app/target/quiz_app-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "quiz_app-0.0.1-SNAPSHOT.jar"]