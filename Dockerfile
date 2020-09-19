FROM openjdk:8-jdk-alpine
MAINTAINER mcdeden <mcdeden@gmail.com>
VOLUME /tmp
EXPOSE 8443
ADD target/*.jar Gateway.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/Gateway.jar"]