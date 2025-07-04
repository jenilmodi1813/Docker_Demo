FROM openjdk:17-alpine
LABEL maintainer="jenil123@gmail.com"
EXPOSE 8080
COPY target/UserService-0.0.1-SNAPSHOT.jar UserService.jar
ENTRYPOINT ["java", "-jar", "UserService.jar"]
