FROM maven3.5.2-jdk-8-alpine AS MAVEN_BUILD

MAINTAINER Brian Hannaway

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre-alpine:lastest

WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/api-jwt-0.1.0.jar /app/

ENTRYPOINT ["java", "-jar", "api-jwt-0.1.0.jar"]
