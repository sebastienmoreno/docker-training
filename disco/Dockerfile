FROM maven:3.5.2-jdk-9 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:9
VOLUME /tmp
COPY --from=build /usr/src/app/target/*.jar app.jar
EXPOSE 8080  
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]