FROM openjdk:17-jdk-alpine
RUN apk --update add --no-cache curl
ARG JAR_FILE=target/*.jar
COPY ./target/ConfigServerHospital-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 9999/TCP
