FROM openjdk:17-alpine
LABEL maintainer="jenil123@gmail.com"
EXPOSE 8082
COPY target/HotelService-0.0.1-SNAPSHOT.jar HotelService.jar
ENTRYPOINT ["java", "-jar", "HotelService.jar"]
