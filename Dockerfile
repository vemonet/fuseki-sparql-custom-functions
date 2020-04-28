FROM maven:3-jdk-8-alpine as build

WORKDIR /app

# Only runs if pom.xml changes. To avoid downloading dependencies everytime.
COPY pom.xml .
RUN mvn verify clean --fail-never

COPY src/ ./src/
RUN mvn package 

# ENTRYPOINT ["/bin/sh"]

# Final running image
FROM openjdk:8-jre-alpine

LABEL maintainer "Vincent Emonet <vincent.emonet@gmail.com>"

WORKDIR /app

COPY --from=build /app/target/translator-sparql-service-0.0.1-SNAPSHOT.jar /app/translator-sparql-service.jar

ADD ./src/main/resources/init.nt /app/init.nt

ENTRYPOINT ["java","-jar","/app/translator-sparql-service.jar"]
#CMD ["-h"]
