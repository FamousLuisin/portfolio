FROM eclipse-temurin:21.0.6_7-jdk-jammy
WORKDIR /api
COPY ./gradle ./gradle
COPY gradlew build.gradle settings.gradle ./
RUN ./gradlew --refresh-dependencies
COPY ./src ./src
EXPOSE 8080
CMD ["./gradlew", "run"]