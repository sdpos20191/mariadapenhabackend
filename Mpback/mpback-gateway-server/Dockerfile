FROM maven:3.6.1-jdk-8-alpine AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/src/app/target/mpback-gateway-server-0.0.1-SNAPSHOT.jar /usr/app/mpback-gateway-server-0.0.1-SNAPSHOT.jar
EXPOSE 9094
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/usr/app/mpback-gateway-server-0.0.1-SNAPSHOT.jar"]