FROM openjdk:17-jdk-alpine
RUN apk --update add --no-cache curl
ARG JAR_FILE=target/*.jar
COPY ./target/ApiUsuario-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080/TCP
