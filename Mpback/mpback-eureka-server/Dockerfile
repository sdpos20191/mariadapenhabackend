FROM maven:3.6.1-jdk-8-alpine AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/src/app/target/mpback-eureka-server-0.0.1-SNAPSHOT.jar /usr/app/mpback-eureka-server-0.0.1-SNAPSHOT.jar
WORKDIR /usr/app/
COPY sleepEntry.sh /usr/app/sleepEntry.sh
RUN chmod 777 /usr/app/sleepEntry.sh
EXPOSE 9091
ENTRYPOINT ["/bin/sh", "/usr/app/sleepEntry.sh", "30", "/usr/app/mpback-eureka-server-0.0.1-SNAPSHOT.jar"]