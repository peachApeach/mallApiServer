FROM openjdk:latest

WORKDIR /app

COPY build/libs/apiserver-0.0.1-SNAPSHOT.jar apiserver.jar

CMD ["java", "-jar", "apiserver.jar"]