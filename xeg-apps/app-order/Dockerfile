FROM openjdk:8-alpine
MAINTAINER devops

ADD ./target/*.jar /app.jar

ENTRYPOINT ["java","-jar","app.jar"]
