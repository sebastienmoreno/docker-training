FROM openjdk:8-jre-alpine

COPY sleep-0.0.1-SNAPSHOT.jar /service.jar

RUN chmod +x /service.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar /service.jar"]