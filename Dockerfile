FROM gradle:jdk17 as gradleimage
COPY . gradle/source
WORKDIR gradle/source
RUN gradle build

FROM openjdk:17
COPY --from=gradleimage gradle/public-transportation:1.0.jar /app/
WORKDIR /app
ENTRYPOINT ["java", "-jar", "public-transportation:1.0.jar"]