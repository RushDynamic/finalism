FROM maven:latest as builder
COPY . /app/src
WORKDIR /app/src
RUN ["mvn", "clean", "package", "-Dmaven.test.skip"]

FROM openjdk:16
COPY --from=builder /app/src/target/finalism-api-server.jar finalism-api-server.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "finalism-api-server.jar"]