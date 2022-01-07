FROM 192.168.16.6:20081/xeg-public/openjdk:8-alpine
MAINTAINER devops

ADD ./target/*.jar /app.jar

ENTRYPOINT ["java","-jar","app.jar"]
