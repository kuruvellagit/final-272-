
FROM openjdk:17-jdk-slim


WORKDIR /app


COPY target/hello-service-0.0.1-SNAPSHOT.jar /app/hello-service.jar


EXPOSE 8081


ENTRYPOINT ["java", "-jar", "hello-service.jar"]