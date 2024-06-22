FROM openjdk:11-jdk-slim-buster
WORKDIR /app
COPY build/libs/ktor-server.jar /app/
ENTRYPOINT ["java", "-jar", "ktor-server.jar"]