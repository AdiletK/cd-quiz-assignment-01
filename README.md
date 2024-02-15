# Quiz Service
This is a Spring Boot application for managing quizzes. It provides RESTful endpoints for creating, reading, updating, and deleting quizzes.

### Requirements before running application:

* Docker
* Java 17
* Maven

### Build
docker build -t quiz-app .

### Run service
docker run -p 8080:8080 quiz-app

Service runs on 8080 port

### Swagger
http://localhost:8080/swagger-ui/index.html#/