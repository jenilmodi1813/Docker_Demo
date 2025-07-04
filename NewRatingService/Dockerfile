FROM openjdk:17-alpine
LABEL maintainer="jenil123@gmail.com"
EXPOSE 8083
COPY target/NewRatingService-0.0.1-SNAPSHOT.jar RatingService.jar
ENTRYPOINT ["java", "-jar", "RatingService.jar"]
