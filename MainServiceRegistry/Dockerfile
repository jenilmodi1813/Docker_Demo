FROM openjdk:17-alpine
LABEL maintainer="jenil123@gmail.com"
EXPOSE 8761
COPY target/MainServiceRegistry-0.0.1-SNAPSHOT.jar MainServiceRegistry.jar
ENTRYPOINT ["java", "-jar", "MainServiceRegistry.jar"]
