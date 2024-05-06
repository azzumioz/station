FROM openjdk:8-jdk-alpine
EXPOSE 8081
COPY target/measurstation-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "measurstation-0.0.1-SNAPSHOT.jar"]

