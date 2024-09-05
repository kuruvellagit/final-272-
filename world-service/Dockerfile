
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/world-service-0.0.1-SNAPSHOT.jar /app/world-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "world-service.jar"]